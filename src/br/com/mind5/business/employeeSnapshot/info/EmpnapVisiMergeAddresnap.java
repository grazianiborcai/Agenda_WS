package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapVisiMergeAddresnap extends InfoMergerVisitorTemplate<EmpnapInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(EmpnapInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 		&&
				baseInfo.codEmployee == selectedInfo.codEmployee	&&
				baseInfo.codSnapshot == selectedInfo.codEmployeeSnapshot	);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, AddresnapInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		baseInfo.addresnaps.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<EmpnapInfo> uniquifyHook(List<EmpnapInfo> results) {
		InfoUniquifier<EmpnapInfo> uniquifier = new EmpnapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
