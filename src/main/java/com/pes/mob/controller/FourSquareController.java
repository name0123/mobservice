/**
 *  FOURSQUARE CONTROLLER
 * AUTHOR: ELOI PARDO
 * 
 * 
 */

package com.pes.mob.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.Place;
import com.pes.mob.service.PlaceService;
import com.pes.mob.service.Prova;


@RestController
@RequestMapping("/4square")
public class FourSquareController {
	@Autowired
	ApplicationContext ac;
	@Autowired 
    PlaceService placeService;
	
	final static String ClientId = "PTGI42UUOXHP0X0LYKBWEFFLLSGEXVUBQDSXYN5R3OPBXROZ";
	final static String ClientSecret = "RWTGHHMMKUEL4KWCITNC2HKQDYVWBGIOUXKHCZ0AKUHFA4KF";
	final static String v = "20151111";
	final static String url = "https://api.foursquare.com/v2/venues/";
	final static String oauth_token = "ZJPW24CEAOKHXMJGGUBCQWMZSZATFNZCFVVC0RCBNLKCREUK";
    
    @RequestMapping("/search")
    public List<Place> searchVenues(@RequestParam(value="ll" , defaultValue="") String ll,
    		@RequestParam(value="near" , defaultValue="") String near,
    		@RequestParam(value="query" , defaultValue="") String query,
    		@RequestParam(value="radius" , defaultValue="") String radius,
    		@RequestParam(value="sw" , defaultValue="") String sw,
    		@RequestParam(value="ne" , defaultValue="") String ne,
    		@RequestParam(value="limit" , defaultValue="50") String limit) throws IOException, JSONException {
    	URL targetUrl = new URL(url+"search?client_id="+ClientId+"&client_secret="+ClientSecret+"&v="+v);
    	if (!ll.equals("")) targetUrl = new URL(targetUrl.toString()+"&ll="+ll);
    	else if (!near.equals("")) targetUrl = new URL(targetUrl.toString()+"&near="+near);
    	else if (!sw.equals("") && !ne.equals("")) targetUrl = new URL(targetUrl.toString()+"&intent=browse"+"&sw="+sw+"&ne="+ne);
    	if (!query.equals("")) targetUrl = new URL(targetUrl.toString()+"&query="+query);
    	if (!radius.equals("") && sw.equals("") && ne.equals("")) targetUrl = new URL(targetUrl.toString()+"&radius="+radius);
    	if (url.equals(targetUrl.toString())) return null;
    	targetUrl = new URL(targetUrl.toString()+"&limit="+limit);
    	System.out.println(targetUrl);
    	List<Place> result = getInfo(targetUrl);
        return result;
    }
    
    @RequestMapping("/get")
    public List<Place> getVenue(@RequestParam(value="venue_id") String venue_id) throws IOException, JSONException {
    	URL targetUrl = new URL(url+venue_id+"?oauth_token="+oauth_token+"&v="+v);
    	List<Place> result = getInfo(targetUrl);
    	return result;
    }
    
    private List<Place> getInfo(URL targetUrl) throws JSONException {
    	HttpURLConnection conn;
    	StringBuilder sb = new StringBuilder();
        String line;
		try {
			conn = (HttpURLConnection) targetUrl.openConnection();
			conn.setRequestMethod("GET");
	        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	         }   
	         rd.close();
		} catch (IOException e) {
			return null;
		}
        
        JSONObject json = new JSONObject(sb.toString());
        if (json.getJSONObject("meta").getInt("code") != 200) return null;
        JSONObject result = json.getJSONObject("response");
        List<Place> places = new ArrayList<Place>();
        if (!result.isNull("venues")) {
	        JSONArray ja = result.getJSONArray("venues");        
	        for (int i = 0; i < ja.length(); ++i) {
	        	JSONObject j = ja.getJSONObject(i);
	        	String id = j.getString("id");
	        	String name = j.getString("name");
	        	Double lat = j.getJSONObject("location").getDouble("lat");
	        	Double lng = j.getJSONObject("location").getDouble("lng");
	        	String category = "";
	        	JSONArray categories = j.getJSONArray("categories");
	        	if (categories.length() > 0) {
	        		category = categories.getJSONObject(0).getString("name");
	        	}
	        	Place place = new Place(id, name, lat, lng, category);
	        	places.add(place);
	        }        
        }
        else {
        	JSONObject j = result.getJSONObject("venue");
        	String id = j.getString("id");
        	String name = j.getString("name");
        	Double lat = j.getJSONObject("location").getDouble("lat");
        	Double lng = j.getJSONObject("location").getDouble("lng");
        	String category = "";
        	JSONArray categories = j.getJSONArray("categories");
        	if (categories.length() > 0) {
        		category = categories.getJSONObject(0).getString("name");
        	}
        	Place place = new Place(id, name, lat, lng, category);
        	if (!placeService.exists(id)) placeService.savePlace(place);
        	else place = placeService.findById(id);
        	places.add(place); 
        }
        Prova prova = (Prova) ac.getBean("prova");
        prova.set(places);
        new Thread(prova).start();
        return places;
    }
}