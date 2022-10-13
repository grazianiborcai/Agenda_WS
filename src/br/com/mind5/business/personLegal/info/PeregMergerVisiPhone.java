package br.com.mind5.business.personLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PeregMergerVisiPhone extends InfoMergerVisitorTemplate<PeregInfo, PhoneInfo> {

	@Override public boolean shouldMerge(PeregInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner    	== selectedInfo.codOwner && 
				baseInfo.codLegalPerson == selectedInfo.codLegalPerson);
	}
	
	
	
	@Override public List<PeregInfo> merge(PeregInfo baseInfo, PhoneInfo selectedInfo) {
		List<PeregInfo> results = new ArrayList<>();
		
		baseInfo.phoneData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
