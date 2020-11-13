package br.com.mind5.geo.geoCode.model.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGeodeCoding extends ActionVisitorTemplateSimple<GeodeInfo> {
	private String REGEX_SPLIT = ",+(?=\")";
	
	public VisiGeodeCoding(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	@Override public List<GeodeInfo> executeTransformationHook(List<GeodeInfo> recordInfos) {
		List<GeodeInfo> results = new ArrayList<>();
		
		for(GeodeInfo eachRecod : recordInfos) {
			List<String> contents = sendHttpRequest(eachRecod);
			
			if (checkHttpResponse(contents) == false)
				return null;
			
			eachRecod.latitude = getLatitute(contents);
			eachRecod.longitude = getLongitude(contents);
			results.add(eachRecod);
		}		
		
		return results;
	}
	
	
	
	private List<String> sendHttpRequest(GeodeInfo recordInfo) {
		try {
			HttpURLConnection con;
			con = getHttpConnection(recordInfo);
			con = addHttpParam(con, recordInfo);
			
			int status = con.getResponseCode();
			if (status != 200)
				return null;
			
			return getResponse(con);
		
		} catch (Exception e) {
			super.logException(e);
			return null;
		}
	}
	
	
	
	private HttpURLConnection getHttpConnection(GeodeInfo recordInfo) throws IOException {		
		URL url = new URL("http://www.mapquestapi.com/geocoding/v1/address");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		return con;
	}
	
	
	
	private HttpURLConnection addHttpParam(HttpURLConnection con, GeodeInfo recordInfo) throws UnsupportedEncodingException, IOException {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "poFk4PFL7oKPLwSFyVsmzrs6HGKiO9Yj");
		parameters.put("outFormat", "csv");
		parameters.put("location", recordInfo.location);
		 
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(getParamsString(parameters));
		
		out.flush();
		out.close();
		
		return con;
	}
	
	
	
    private String getParamsString(Map<String, String> params) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
 
        for (Map.Entry<String, String> entry : params.entrySet()) {
        //result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
          result.append(entry.getKey());
          result.append("=");
        //result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
          result.append(entry.getValue());
          result.append("&");
        }
 
        String resultString = result.toString();
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
    }
    
    
    
	private List<String> getResponse(HttpURLConnection con) throws UnsupportedEncodingException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		List<String> contents = new ArrayList<>();
		
		while ((inputLine = in.readLine()) != null) {
			contents.add(inputLine);
		}
		
		in.close();		
		return contents;
	}
	
	
	
	private float getLatitute(List<String> contents) {
		String lineData = getLineData(contents);
		int latPos = getLatPosition(contents);
		
		String[] values = lineData.split(REGEX_SPLIT);
		return stringToFloat(values[latPos]);
	}
	
	
	
	private float getLongitude(List<String> contents) {
		String lineData = getLineData(contents);
		int lngPos = getLngPosition(contents);
		
		String[] values = lineData.split(REGEX_SPLIT);
		return stringToFloat(values[lngPos]);
	}
	
	
	
	private int getLatPosition(List<String> contents) {
		String headerData = getHeaderData(contents);
		
		String[] values = headerData.split(REGEX_SPLIT);
		int latPos = -1;
		String latStr = "\"Lat\"";
		
		for(int i=0; i < values.length-1; i++) {
			if (values[i].equals(latStr))
				latPos = i;
		}
		
		return latPos;
	}
	
	
	
	private int getLngPosition(List<String> contents) {
		String headerData = getHeaderData(contents);
		
		String[] values = headerData.split(REGEX_SPLIT);
		int lngPos = -1;
		String lngStr = "\"Lng\"";
		
		for(int i=0; i < values.length-1; i++) {
			if (values[i].equals(lngStr))
				lngPos = i;
		}
		
		return lngPos;
	}
	
	
	
	private String getHeaderData(List<String> contents) {
		if (checkContents(contents) == false)
			return null;		
		
		return contents.get(0);
	}
	
	
	
	private String getLineData(List<String> contents) {
		if (checkContents(contents) == false)
			return null;		
		
		return contents.get(1);
	}
	
	
	
	private boolean checkContents(List<String> contents) {
		if (contents == null)
			return false;		
		
		if (contents.isEmpty())
			return false;		
		
		return true;
	}
	
	
	
	private float stringToFloat(String value) {
		String number = value.replaceAll("\"+","");
		return Float.valueOf(number);
	}
	
	
	
	private boolean checkHttpResponse(List<String> contents) {
		if (contents == null)
			return false;
		
		if (contents.isEmpty())
			return false;
		
		if (contents.size() == 1)
			return false;
		
		return true;
	}	
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.GEO_CODE_GENERATE_ERROR;
	}
}
