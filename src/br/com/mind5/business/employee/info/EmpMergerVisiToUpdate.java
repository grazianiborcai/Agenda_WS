package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpMergerVisiToUpdate extends InfoMergerVisitorTemplate<EmpInfo, EmpInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, EmpInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmpInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
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
