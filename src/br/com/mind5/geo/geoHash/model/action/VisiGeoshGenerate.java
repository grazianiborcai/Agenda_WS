package br.com.mind5.geo.geoHash.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import ch.hsr.geohash.GeoHash;

final class VisiGeoshGenerate extends ActionVisitorTemplateSimple<GeoshInfo> {
	
	public VisiGeoshGenerate(DeciTreeOption<GeoshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<GeoshInfo> executeTransformationHook(List<GeoshInfo> recordInfos) {
		List<GeoshInfo> results = new ArrayList<>();
		
		for(GeoshInfo eachRecod : recordInfos) {
			String response = getHash(eachRecod);
			
			if (response == null)
				return null;
			
			eachRecod.geoHash12  = response;
			eachRecod.geoHash05  = response.substring(0, 5);
			eachRecod.geoHash04  = response.substring(0, 4);
			eachRecod.geoHash03  = response.substring(0, 3);
			eachRecod.geoHash02  = response.substring(0, 2);
			eachRecod.geoHash01  = response.substring(0, 1);
			
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private String getHash(GeoshInfo recordInfo) {
		final int PRECISION = 12;
		
		try {
			GeoHash geoHash = GeoHash.withCharacterPrecision(recordInfo.latitude, recordInfo.longitude, PRECISION);
			return geoHash.toBase32();
		
		} catch (Exception e) {
			super.logException(e);
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.GEO_HASH_GENERATE_ERROR;
	}
}
