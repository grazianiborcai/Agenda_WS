package br.com.mind5.form.formAddress.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FormessVisiMergeToSelect implements InfoMergerVisitor<FormessInfo, FormessInfo> {
	
	@Override public List<FormessInfo> beforeMerge(List<FormessInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FormessInfo baseInfo, FormessInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormessInfo> merge(FormessInfo baseInfo, FormessInfo selectedInfo) {
		List<FormessInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FormessInfo> getUniquifier() {
		return null;
	}
}
