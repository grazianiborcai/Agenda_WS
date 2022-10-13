package br.com.mind5.business.personLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PeregMergerVisiAddress extends InfoMergerVisitorTemplate<PeregInfo, AddressInfo> {

	@Override public boolean shouldMerge(PeregInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner 	&& 
				baseInfo.codLegalPerson == selectedInfo.codLegalPerson		);
	}
	
	
	
	@Override public List<PeregInfo> merge(PeregInfo baseInfo, AddressInfo selectedInfo) {
		List<PeregInfo> results = new ArrayList<>();
		
		baseInfo.addressData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
