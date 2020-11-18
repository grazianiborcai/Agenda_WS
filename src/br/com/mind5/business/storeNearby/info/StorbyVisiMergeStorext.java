package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorbyVisiMergeStorext extends InfoMergerVisitorTemplate<StorbyInfo, StorextInfo> {
	
	@Override public List<StorbyInfo> beforeMerge(List<StorbyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, StorextInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.storextData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorbyInfo> getUniquifier() {
		return null;
	}
}
