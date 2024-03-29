package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyMergerVisiGeosh extends InfoMergerVisitorTemplate<StorbyInfo, GeoshInfo> {

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
}
