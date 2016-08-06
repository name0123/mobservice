package com.pes.mob.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.model.ValorFourId;
import com.pes.mob.model.ValorLatLong;
import com.pes.mob.model.Valoration;
import com.pes.mob.service.PlaceService;
import com.pes.mob.service.UserService;
import com.pes.mob.service.ValorationService;

@RestController
@RequestMapping(value="/valorations", headers = "Accept=application/json")
public class ValorationController {
    @Autowired 
    ValorationService valorationService;
    @Autowired
    UserService userService;
    @Autowired
    PlaceService placeService;
	
	
    @RequestMapping(value = { "/getall" }, method = RequestMethod.GET)
    public  @ResponseBody List<Valoration> getAllValorations() {
    	return valorationService.findAllValorations();      
       
    }
    
    @RequestMapping(value = { "/getcs" }, method = RequestMethod.GET)
    public Valoration getValorationCoords(@RequestParam (value="ll", defaultValue="") String ll){
       // out-of-date :: not well done!
    	return valorationService.findByCoordinates(ll);
       
    }
    @RequestMapping(value = { "/getfour" }, method = RequestMethod.GET)
    public List<Valoration> getValorations(@RequestParam (value="four", defaultValue="") String four_id){
    	// returns the valorations of the place with four_id=four
    	Place p = placeService.findById(four_id);
    	return valorationService.findByFourId(four_id);
        // you should have a function to get last valoration       
    }  

    @RequestMapping(value = "/newcs", method = RequestMethod.POST)
    public ResponseEntity<Valoration> saveValorationCs(@RequestBody ValorLatLong vall) {
    	Place p = getThePlace(vall.getLat(),vall.getLng());
    	User u = userService.findById(vall.getUid());
    	Valoration v = new Valoration(vall.getAc(), vall.getWc(), vall.getEl(), vall.getUid(), p.getFour_id());
    	valorationService.saveValoration(v, u, p );
    	placeService.updatePlace(p);
    	return new ResponseEntity<Valoration>(v,HttpStatus.OK);

    }
    @RequestMapping(value = "/newfour", method = RequestMethod.POST)
    public ResponseEntity<Valoration> saveValorationFi(@RequestBody ValorFourId vall) {
    	// we must have the place in DB (we called url search before!)
    	Place p = placeService.findById(vall.getFour_id());
    	User u = userService.findById(vall.getUid());
    	Valoration v = new Valoration(vall.getAc(), vall.getWc(), vall.getEl(), vall.getUid(), vall.getFour_id());
    	valorationService.saveValoration(v, u, p );
    	placeService.updatePlace(p);
    	return new ResponseEntity<Valoration>(v,HttpStatus.OK);

    }

      public static String callURL(String myURL) {
  		System.out.println("Requested URL:" + myURL);
  		StringBuilder sb = new StringBuilder();
  		URLConnection urlConn = null;
  		InputStreamReader in = null;
  		try {
  			URL url = new URL(myURL);
  			urlConn = url.openConnection();
  			if (urlConn != null)
  				urlConn.setReadTimeout(60 * 1000);
  			if (urlConn != null && urlConn.getInputStream() != null) {
  				in = new InputStreamReader(urlConn.getInputStream(),
  						Charset.defaultCharset());
  				BufferedReader bufferedReader = new BufferedReader(in);
  				if (bufferedReader != null) {
  					int cp;
  					while ((cp = bufferedReader.read()) != -1) {
  						sb.append((char) cp);
  					}
  					bufferedReader.close();
  				}
  			}
  		in.close();
  		} catch (Exception e) {
  			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
  		} 
   
  		return sb.toString();
  	}
   
    
	private Place getThePlace(Double lat, Double lng) {
		// this should be not used!
		String urls = "https://mobserv.herokuapp.com/4square/search?ll="+lat.toString()+','+lng.toString();
		String jstring = callURL(urls);
		JSONArray jsonArray = null;
		try {  
			jsonArray = new JSONArray(jstring);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONObject opl = null;
		try {
			opl = (JSONObject) jsonArray.get(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sf = null;
		try {
			sf = (String) opl.get("four_id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Place p = placeService.findById(sf);
		return p;
	}
}

