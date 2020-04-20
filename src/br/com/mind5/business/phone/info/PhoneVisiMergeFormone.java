package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PhoneVisiMergeFormone implements InfoMergerVisitorV3<PhoneInfo, FormoneInfo> {
	
	@Override public List<PhoneInfo> beforeMerge(List<PhoneInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhoneInfo baseInfo, FormoneInfo selectedInfo) {
		return (baseInfo.codCountry == selectedInfo.codCountry);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, FormoneInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhoneInfo> getUniquifier() {
		return null;
	}
}