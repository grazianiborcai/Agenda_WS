package br.com.mind5.form.formAddressSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FormesarchVisiMergeToSelect implements InfoMergerVisitor<FormesarchInfo, FormesarchInfo> {
	
	@Override public List<FormesarchInfo> beforeMerge(List<FormesarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FormesarchInfo baseInfo, FormesarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormesarchInfo> merge(FormesarchInfo baseInfo, FormesarchInfo selectedInfo) {
		List<FormesarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FormesarchInfo> getUniquifier() {
		return null;
	}
}
