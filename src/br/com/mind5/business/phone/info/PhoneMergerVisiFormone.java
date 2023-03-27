package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneMergerVisiFormone extends InfoMergerVisitorTemplate<PhoneInfo, FormoneInfo> {

	@Override public boolean shouldMerge(PhoneInfo baseInfo, FormoneInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry));
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, FormoneInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
}
