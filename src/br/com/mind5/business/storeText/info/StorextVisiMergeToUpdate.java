package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorextVisiMergeToUpdate extends InfoMergerVisitorTemplate<StorextInfo, StorextInfo> {

	@Override public boolean shouldMerge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore   == selectedInfo.codStore   &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, StorextInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
}
