package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpVisiMergePerarch extends InfoMergerVisitorTemplate<EmpInfo, PerarchInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, PerarchInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
}
