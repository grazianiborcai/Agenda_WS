package br.com.mind5.geo.geoCode.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.country.info.CountryInfo;

final class GeodeVisiMergeCountry implements InfoMergerVisitor<GeodeInfo, CountryInfo> {
	
	@Override public List<GeodeInfo> beforeMerge(List<GeodeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(GeodeInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<GeodeInfo> merge(GeodeInfo baseInfo, CountryInfo selectedInfo) {
		List<GeodeInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<GeodeInfo> getUniquifier() {
		return null;
	}
}
