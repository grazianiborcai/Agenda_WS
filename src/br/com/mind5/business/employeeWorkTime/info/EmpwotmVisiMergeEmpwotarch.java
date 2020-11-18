package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmVisiMergeEmpwotarch extends InfoMergerVisitorTemplate<EmpwotmInfo, EmpwotarchInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwotarchInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		EmpwotmInfo result = EmpwotmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
