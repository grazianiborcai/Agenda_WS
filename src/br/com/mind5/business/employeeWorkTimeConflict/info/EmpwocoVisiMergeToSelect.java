package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwocoVisiMergeToSelect extends InfoMergerVisitorTemplate<EmpwocoInfo, EmpwocoInfo> {

	@Override public boolean shouldMerge(EmpwocoInfo baseInfo, EmpwocoInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwocoInfo> merge(EmpwocoInfo baseInfo, EmpwocoInfo selectedInfo) {
		List<EmpwocoInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
