package br.com.mind5.business.employeeMaterial.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpmatVisiMergeEmplres extends InfoMergerVisitorTemplate<EmpmatInfo, EmplresInfo> {
	
	@Override public boolean shouldMerge(EmpmatInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner		&&
				baseInfo.codEmployee == selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<EmpmatInfo> merge(EmpmatInfo baseInfo, EmplresInfo selectedInfo) {
		List<EmpmatInfo> results = new ArrayList<>();
		
		baseInfo.emplresData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
