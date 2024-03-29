package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpMergerVisiUsername extends InfoMergerVisitorTemplate<EmpInfo, UsernameInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, UsernameInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
