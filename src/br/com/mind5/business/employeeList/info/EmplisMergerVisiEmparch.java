package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplisMergerVisiEmparch extends InfoMergerVisitorTemplate<EmplisInfo, EmparchInfo> {
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, EmparchInfo selectedInfo) {
		boolean result = (baseInfo.codOwner == selectedInfo.codOwner);
		
		if (result == false)
			return result;
		
		if (baseInfo.codPerson > 0)
			result = (baseInfo.codPerson == selectedInfo.codPerson);
		
		if (result == false)
			return result;
		
		return result;
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, EmparchInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		EmplisInfo result = EmplisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
