package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpMergerVisiEmplutm extends InfoMergerVisitorTemplate<EmpInfo, EmplutmInfo> {
	
	@Override protected List<EmpInfo> beforeMergeHook(List<EmpInfo> baseInfos) {
		for (EmpInfo eachEmp : baseInfos) {
			eachEmp.emplutmes = new ArrayList<>();
		}

		return baseInfos;
	}
	
	

	@Override public boolean shouldMerge(EmpInfo baseInfo, EmplutmInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner		&&
				baseInfo.codStore 	 == selectedInfo.codStore		&&
				baseInfo.codEmployee == selectedInfo.codEmployee);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmplutmInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.emplutmes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
