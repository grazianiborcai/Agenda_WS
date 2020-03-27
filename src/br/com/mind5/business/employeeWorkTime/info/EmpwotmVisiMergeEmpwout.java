package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmVisiMergeEmpwout implements InfoMergerVisitorV3<EmpwotmInfo, EmpwoutInfo> {
	
	@Override public List<EmpwotmInfo> beforeMerge(List<EmpwotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, EmpwoutInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, EmpwoutInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		EmpwotmInfo result = EmpwotmInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpwotmInfo> getUniquifier() {
		return null;
	}
}
