package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneMergerVisiPhonarch extends InfoMergerVisitorTemplate<PhoneInfo, PhonarchInfo> {

	@Override public boolean shouldMerge(PhoneInfo baseInfo, PhonarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, PhonarchInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		PhoneInfo result = PhoneInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
