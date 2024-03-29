package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusMergerVisiToUpdate extends InfoMergerVisitorTemplate<CusInfo, CusInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CusInfo selectedInfo) {		
		List<CusInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		if (baseInfo.addresses != null)
			selectedInfo.addresses = baseInfo.addresses;
		
		if (baseInfo.phones != null)
			selectedInfo.phones = baseInfo.phones;
		
		if (baseInfo.personData != null)
			selectedInfo.personData = baseInfo.personData;
		
		results.add(selectedInfo);
		return results;
	}
}
