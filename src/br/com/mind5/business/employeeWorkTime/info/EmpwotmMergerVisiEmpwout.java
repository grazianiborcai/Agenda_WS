package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmMergerVisiEmpwout extends InfoMergerVisitorTemplate<EmpwotmInfo, EmpwoutInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwoutInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwoutInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		EmpwotmInfo result = EmpwotmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
