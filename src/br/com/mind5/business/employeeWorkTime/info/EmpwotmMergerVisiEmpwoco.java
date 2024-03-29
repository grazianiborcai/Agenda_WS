package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmMergerVisiEmpwoco extends InfoMergerVisitorTemplate<EmpwotmInfo, EmpwocoInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwocoInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwocoInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		EmpwotmInfo result = EmpwotmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
