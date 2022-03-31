package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorextMergerVisiToSelect extends InfoMergerVisitorTemplate<StorextInfo, StorextInfo> {

	@Override public boolean shouldMerge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
