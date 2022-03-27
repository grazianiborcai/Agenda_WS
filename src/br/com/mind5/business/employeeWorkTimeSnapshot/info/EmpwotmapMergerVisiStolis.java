package br.com.mind5.business.employeeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmapMergerVisiStolis extends InfoMergerVisitorTemplate<EmpwotmapInfo, StolisInfo> {
	
	@Override public boolean shouldMerge(EmpwotmapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<EmpwotmapInfo> merge(EmpwotmapInfo baseInfo, StolisInfo selectedInfo) {
		List<EmpwotmapInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
