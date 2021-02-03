package br.com.mind5.business.materialTextSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatextarchVisiMergeToSelect extends InfoMergerVisitorTemplate<MatextarchInfo, MatextarchInfo> {

	@Override public boolean shouldMerge(MatextarchInfo baseInfo, MatextarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextarchInfo> merge(MatextarchInfo baseInfo, MatextarchInfo selectedInfo) {
		List<MatextarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
