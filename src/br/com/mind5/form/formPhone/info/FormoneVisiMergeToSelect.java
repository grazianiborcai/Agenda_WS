package br.com.mind5.form.formPhone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class FormoneVisiMergeToSelect extends InfoMergerVisitorTemplate<FormoneInfo, FormoneInfo> {
	
	@Override public List<FormoneInfo> beforeMerge(List<FormoneInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FormoneInfo baseInfo, FormoneInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormoneInfo> merge(FormoneInfo baseInfo, FormoneInfo selectedInfo) {
		List<FormoneInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FormoneInfo> getUniquifier() {
		return null;
	}
}
