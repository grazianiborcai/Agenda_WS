package br.com.mind5.business.employeeMaterial.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatVisiMergeEmpmarch extends InfoMergerVisitorTemplate<EmpmatInfo, EmpmarchInfo> {
	
	@Override public List<EmpmatInfo> beforeMerge(List<EmpmatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpmatInfo baseInfo, EmpmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpmatInfo> merge(EmpmatInfo baseInfo, EmpmarchInfo selectedInfo) {
		List<EmpmatInfo> results = new ArrayList<>();
		
		EmpmatInfo result = EmpmatInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpmatInfo> getUniquifier() {
		return new EmpmatUniquifier();
	}
}
