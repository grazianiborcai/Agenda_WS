package br.com.mind5.business.employeeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmplateMergerVisiUsername extends InfoMergerVisitorTemplate<EmplateInfo, UsernameInfo> {

	@Override public boolean shouldMerge(EmplateInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<EmplateInfo> merge(EmplateInfo baseInfo, UsernameInfo selectedInfo) {
		List<EmplateInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
