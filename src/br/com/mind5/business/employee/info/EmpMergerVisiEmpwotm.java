package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpMergerVisiEmpwotm extends InfoMergerVisitorTemplate<EmpInfo, EmpwotmInfo> {
	
	@Override protected List<EmpInfo> beforeMergeHook(List<EmpInfo> baseInfos) {
		for (EmpInfo eachEmp : baseInfos) {
			eachEmp.empwotmes = new ArrayList<>();
		}

		return baseInfos;
	}
	
	

	@Override public boolean shouldMerge(EmpInfo baseInfo, EmpwotmInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner		&&
				baseInfo.codStore 	 == selectedInfo.codStore		&&
				baseInfo.codEmployee == selectedInfo.codEmployee);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmpwotmInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.empwotmes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
