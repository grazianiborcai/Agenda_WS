package br.com.mind5.form.formPhone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FormoneMergerVisiToSelect extends InfoMergerVisitorTemplate<FormoneInfo, FormoneInfo> {

	@Override public boolean shouldMerge(FormoneInfo baseInfo, FormoneInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormoneInfo> merge(FormoneInfo baseInfo, FormoneInfo selectedInfo) {
		List<FormoneInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
