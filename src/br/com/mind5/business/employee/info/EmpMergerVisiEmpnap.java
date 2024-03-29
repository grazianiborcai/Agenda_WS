package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpMergerVisiEmpnap extends InfoMergerVisitorTemplate<EmpInfo, EmpnapInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, EmpnapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner		&&
				baseInfo.codEmployee == selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmpnapInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
