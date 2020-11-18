package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmVisiMergeStolis extends InfoMergerVisitorTemplate<EmpwotmInfo, StolisInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, StolisInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
