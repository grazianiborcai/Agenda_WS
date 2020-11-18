package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorextVisiMergeToDelete extends InfoMergerVisitorTemplate<StorextInfo, StorextInfo> {
	
	@Override public List<StorextInfo> beforeMerge(List<StorextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codStore   == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextInfo> getUniquifier() {
		return null;
	}
}
