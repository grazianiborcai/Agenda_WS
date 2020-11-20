package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpVisiMergeEmparch extends InfoMergerVisitorTemplate<EmpInfo, EmparchInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, EmparchInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmparchInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		EmpInfo result = EmpInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
