package br.com.mind5.geo.geoCode.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.state.info.StateInfo;

final class GeodeVisiMergeState implements InfoMergerVisitorV3<GeodeInfo, StateInfo> {
	
	@Override public List<GeodeInfo> beforeMerge(List<GeodeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(GeodeInfo baseInfo, StateInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<GeodeInfo> merge(GeodeInfo baseInfo, StateInfo selectedInfo) {
		List<GeodeInfo> results = new ArrayList<>();
		
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<GeodeInfo> getUniquifier() {
		return null;
	}
}
