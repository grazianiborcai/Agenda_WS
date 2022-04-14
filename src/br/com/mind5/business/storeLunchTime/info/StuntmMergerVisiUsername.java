package br.com.mind5.business.storeLunchTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class StuntmMergerVisiUsername extends InfoMergerVisitorTemplate<StuntmInfo, UsernameInfo> {

	@Override public boolean shouldMerge(StuntmInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StuntmInfo> merge(StuntmInfo baseInfo, UsernameInfo selectedInfo) {
		List<StuntmInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
