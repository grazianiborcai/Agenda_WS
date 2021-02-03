package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmpnapVisiMergeUselis extends InfoMergerVisitorTemplate<EmpnapInfo, UselisInfo> {

	@Override public boolean shouldMerge(EmpnapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, UselisInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<EmpnapInfo> uniquifyHook(List<EmpnapInfo> results) {
		InfoUniquifier<EmpnapInfo> uniquifier = new EmpnapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
