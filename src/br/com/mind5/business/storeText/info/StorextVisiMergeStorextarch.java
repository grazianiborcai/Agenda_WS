package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorextVisiMergeStorextarch extends InfoMergerVisitorTemplate<StorextInfo, StorextarchInfo> {
	
	@Override public List<StorextInfo> beforeMerge(List<StorextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextInfo baseInfo, StorextarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, StorextarchInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		StorextInfo result = StorextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextInfo> getUniquifier() {
		return null;
	}
}
