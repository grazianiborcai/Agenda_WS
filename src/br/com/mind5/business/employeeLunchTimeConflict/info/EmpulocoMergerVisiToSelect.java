package br.com.mind5.business.employeeLunchTimeConflict.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpulocoMergerVisiToSelect extends InfoMergerVisitorTemplate<EmpulocoInfo, EmpulocoInfo> {

	@Override public boolean shouldMerge(EmpulocoInfo baseInfo, EmpulocoInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpulocoInfo> merge(EmpulocoInfo baseInfo, EmpulocoInfo selectedInfo) {
		List<EmpulocoInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
