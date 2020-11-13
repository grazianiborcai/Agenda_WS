package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpVisiMergeEmparch implements InfoMergerVisitor<EmpInfo, EmparchInfo> {
	
	@Override public List<EmpInfo> beforeMerge(List<EmpInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, EmparchInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, EmparchInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		EmpInfo result = EmpInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpInfo> getUniquifier() {
		return new EmpUniquifier();
	}
}
