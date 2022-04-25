package br.com.mind5.business.employeeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmplutmMergerVisiUsername extends InfoMergerVisitorTemplate<EmplutmInfo, UsernameInfo> {
	
	@Override public boolean shouldMerge(EmplutmInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<EmplutmInfo> merge(EmplutmInfo baseInfo, UsernameInfo selectedInfo) {
		List<EmplutmInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
