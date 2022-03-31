package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddresnapMergerVisiEmplis extends InfoMergerVisitorTemplate<AddresnapInfo, EmplisInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner  	 == selectedInfo.codOwner	&&
				baseInfo.codEmployee == selectedInfo.codEmployee);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, EmplisInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.codEmployeeSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
