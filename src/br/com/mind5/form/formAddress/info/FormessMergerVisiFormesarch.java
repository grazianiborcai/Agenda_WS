package br.com.mind5.form.formAddress.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FormessMergerVisiFormesarch extends InfoMergerVisitorTemplate<FormessInfo, FormesarchInfo> {

	@Override public boolean shouldMerge(FormessInfo baseInfo, FormesarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormessInfo> merge(FormessInfo baseInfo, FormesarchInfo selectedInfo) {
		List<FormessInfo> results = new ArrayList<>();
		
		FormessInfo result = FormessInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
