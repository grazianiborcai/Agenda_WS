package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class EmpMergerVisiUserarch extends InfoMergerVisitorTemplate<EmpInfo, UserarchInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, UserarchInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
