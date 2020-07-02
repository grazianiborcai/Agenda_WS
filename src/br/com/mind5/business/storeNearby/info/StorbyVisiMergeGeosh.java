package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeGeosh implements InfoMergerVisitorV3<StorbyInfo, GeoshInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, GeoshInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, GeoshInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.geoHash01 = selectedInfo.geoHash01;
		baseInfo.geoHash02 = selectedInfo.geoHash02;
		baseInfo.geoHash03 = selectedInfo.geoHash03;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
