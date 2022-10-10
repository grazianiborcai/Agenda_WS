package br.com.mind5.geo.geoMapquest.model.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.geo.geoMapquest.info.GeoquestInfo;
import br.com.mind5.json.standard.JstdBodyParser;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GeoquestVisiCoding extends ActionVisitorTemplateSimple<GeoquestInfo> {
	public GeoquestVisiCoding(DeciTreeOption<GeoquestInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<GeoquestInfo> executeTransformationHook(List<GeoquestInfo> recordInfos) {
		List<GeoquestInfo> results = new ArrayList<>();
		
		for(GeoquestInfo eachRecod : recordInfos) {
			List<String> contents = sendHttpRequest(eachRecod);
			
			if (checkHttpResponse(contents) == false) {
				return null;
			}
			
			GeoquestInfo parsedResponse = parseResponse(contents.get(0));
			GeoquestInfo mergedResponse = mergeResponse(eachRecod, parsedResponse);
			
			results.add(mergedResponse);

		}
			
		
		return results;
	}
	
	
	
	private List<String> sendHttpRequest(GeoquestInfo recordInfo) {
		try {
			HttpURLConnection con;
			con = buildHttpConnection(recordInfo);
			
			int status = con.getResponseCode();
			if (status != 200)
				return null;
			
			return getResponse(con);
		
		} catch (Exception e) {
			super.logException(e);
			return null;
		}
	}
	
	
	
	private HttpURLConnection buildHttpConnection(GeoquestInfo recordInfo) throws IOException {
		String httpAddress = "http://www.mapquestapi.com/geocoding/v1/address";
		String uri = addQueryParam(recordInfo, httpAddress);
		
		URL url = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		return con;
	}
	
	
	
	private String addQueryParam(GeoquestInfo recordInfo, String httpAddress) throws UnsupportedEncodingException, IOException {
		Map<String, String> queryParams = getQueryParams(recordInfo);
		String queryParamsStr = queryParamsToString(queryParams);
		
		return httpAddress + "?" + queryParamsStr;
	}
	
	
	
	private Map<String, String> getQueryParams(GeoquestInfo recordInfo) throws UnsupportedEncodingException, IOException {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "msn2373R5hOmncv0YhGgu9VrU40Gbqi7");
		parameters.put("outFormat", "json");
		parameters.put("location", recordInfo.location);
		
		return parameters;
	}
	
	
	
    private String queryParamsToString(Map<String, String> params) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
 
        for (Map.Entry<String, String> entry : params.entrySet()) {
          result.append(encodeQueryParam(entry.getKey()));
          result.append("=");
          result.append(entry.getValue());
          result.append("&");
        }        
 
        String resultString = result.toString();
        return resultString.substring(0, resultString.length() - 1);
    }
    
    
    
    private String encodeQueryParam(String queryParam) throws UnsupportedEncodingException {
        return URLEncoder.encode(queryParam, "UTF-8");
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
	
	
	
	private GeoquestInfo parseResponse(String content) {
		JstdBodyParser<GeoquestInfo> parser = new JstdBodyParser<>(GeoquestInfo.class);
		
		List<GeoquestInfo> results = parser.parse(content);
		
		if(results == null) {
			return null;
		}
			
		if(results.isEmpty()) {
			return null;
		}
		
		return results.get(0);
	}
	
	
	
	private GeoquestInfo mergeResponse(GeoquestInfo record, GeoquestInfo response) {
		if (response == null) {
			return null;
		}
		
		response.codLanguage = record.codLanguage;
		response.location = record.location;
		
		return response;
	}
	
	
	
	private boolean checkHttpResponse(List<String> contents) {
		if (contents == null)
			return false;
		
		if (contents.isEmpty())
			return false;
		
		return true;
	}	
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.GEO_CODE_GENERATE_ERROR;
	}
}
