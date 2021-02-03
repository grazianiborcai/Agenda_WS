package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneVisiMergePhonault extends InfoMergerVisitorTemplate<PhoneInfo, PhonaultInfo> {

	@Override public boolean shouldMerge(PhoneInfo baseInfo, PhonaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, PhonaultInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		PhoneInfo result = PhoneInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
