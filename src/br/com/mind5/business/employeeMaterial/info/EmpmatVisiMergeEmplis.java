package br.com.mind5.business.employeeMaterial.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatVisiMergeEmplis implements InfoMergerVisitorV3<EmpmatInfo, EmplisInfo> {
	
	@Override public List<EmpmatInfo> beforeMerge(List<EmpmatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpmatInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner		&&
				baseInfo.codEmployee == selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<EmpmatInfo> merge(EmpmatInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmpmatInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpmatInfo> getUniquifier() {
		return new EmpmatUniquifier();
	}
}
