package br.com.mind5.form.formAddress.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FormessVisiMergeToSelect extends InfoMergerVisitorTemplate<FormessInfo, FormessInfo> {

	@Override public boolean shouldMerge(FormessInfo baseInfo, FormessInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormessInfo> merge(FormessInfo baseInfo, FormessInfo selectedInfo) {
		List<FormessInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
