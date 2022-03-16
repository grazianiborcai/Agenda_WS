package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StolisMergerVisiStorext extends InfoMergerVisitorTemplate<StolisInfo, StorextInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, StorextInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.storextData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
