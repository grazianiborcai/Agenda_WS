package br.com.mind5.business.storeTextSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorextarchVisiMergeToSelect extends InfoMergerVisitorTemplate<StorextarchInfo, StorextarchInfo> {
	
	@Override public List<StorextarchInfo> beforeMerge(List<StorextarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextarchInfo baseInfo, StorextarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextarchInfo> merge(StorextarchInfo baseInfo, StorextarchInfo selectedInfo) {
		List<StorextarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextarchInfo> getUniquifier() {
		return null;
	}
}
