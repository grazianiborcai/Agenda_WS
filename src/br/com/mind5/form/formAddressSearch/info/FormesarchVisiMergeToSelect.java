package br.com.mind5.form.formAddressSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FormesarchVisiMergeToSelect extends InfoMergerVisitorTemplate<FormesarchInfo, FormesarchInfo> {

	@Override public boolean shouldMerge(FormesarchInfo baseInfo, FormesarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormesarchInfo> merge(FormesarchInfo baseInfo, FormesarchInfo selectedInfo) {
		List<FormesarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
