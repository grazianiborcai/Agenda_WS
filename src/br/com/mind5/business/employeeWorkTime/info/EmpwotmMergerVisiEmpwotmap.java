package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmMergerVisiEmpwotmap extends InfoMergerVisitorTemplate<EmpwotmInfo, EmpwotmapInfo> {

	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwotmapInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner    &&
				baseInfo.codStore    == selectedInfo.codStore    &&
				baseInfo.codEmployee == selectedInfo.codEmployee &&
				baseInfo.codWeekday  == selectedInfo.codWeekday);
	}
	
	

	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwotmapInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
