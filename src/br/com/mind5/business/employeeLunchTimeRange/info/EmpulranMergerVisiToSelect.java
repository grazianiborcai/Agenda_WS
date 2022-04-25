package br.com.mind5.business.employeeLunchTimeRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpulranMergerVisiToSelect extends InfoMergerVisitorTemplate<EmpulranInfo, EmpulranInfo> {

	@Override public boolean shouldMerge(EmpulranInfo baseInfo, EmpulranInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpulranInfo> merge(EmpulranInfo baseInfo, EmpulranInfo selectedInfo) {
		List<EmpulranInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
