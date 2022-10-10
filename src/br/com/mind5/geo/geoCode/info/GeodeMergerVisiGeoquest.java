package br.com.mind5.geo.geoCode.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoMapquest.info.GeoquestInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class GeodeMergerVisiGeoquest extends InfoMergerVisitorTemplate<GeodeInfo, GeoquestInfo> {

	@Override public boolean shouldMerge(GeodeInfo baseInfo, GeoquestInfo selectedInfo) {
		return baseInfo.location.equals(selectedInfo.location);
	}
	
	
	
	@Override public List<GeodeInfo> merge(GeodeInfo baseInfo, GeoquestInfo selectedInfo) {
		List<GeodeInfo> results = new ArrayList<>();
		
		if(hasLatLng(selectedInfo) == true) {
			baseInfo.latitude = stringToFloat(selectedInfo.results.get(0).locations.get(0).latLng.lat);
			baseInfo.longitude = stringToFloat(selectedInfo.results.get(0).locations.get(0).latLng.lng);
		}
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private boolean hasLatLng(GeoquestInfo selectedInfo) {
		if (selectedInfo.results == null)
			return false;
		
		if (selectedInfo.results.isEmpty())
			return false;
		
		if (selectedInfo.results.get(0).locations == null)
			return false;
		
		if (selectedInfo.results.get(0).locations.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private float stringToFloat(String value) {
		String number = value.replaceAll("\"+","");
		return Float.valueOf(number);
	}
}
