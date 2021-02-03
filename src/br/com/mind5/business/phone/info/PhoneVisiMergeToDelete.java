package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneVisiMergeToDelete extends InfoMergerVisitorTemplate<PhoneInfo, PhoneInfo> {

	
	@Override public boolean shouldMerge(PhoneInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, PhoneInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
