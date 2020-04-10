package br.com.mind5.business.form.formAddress.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class FormessVisiMergeFormesarch implements InfoMergerVisitorV3<FormessInfo, FormesarchInfo> {
	
	@Override public List<FormessInfo> beforeMerge(List<FormessInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FormessInfo baseInfo, FormesarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<FormessInfo> merge(FormessInfo baseInfo, FormesarchInfo selectedInfo) {
		List<FormessInfo> results = new ArrayList<>();
		
		FormessInfo result = FormessInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FormessInfo> getUniquifier() {
		return null;
	}
}
