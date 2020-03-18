package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpVisiMergePerarch implements InfoMergerVisitorV3<EmpInfo, PerarchInfo> {
	
	@Override public List<EmpInfo> beforeMerge(List<EmpInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, PerarchInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpInfo> getUniquifier() {
		return new EmpUniquifier();
	}
}
