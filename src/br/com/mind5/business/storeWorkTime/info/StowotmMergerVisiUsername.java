package br.com.mind5.business.storeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class StowotmMergerVisiUsername extends InfoMergerVisitorTemplate<StowotmInfo, UsernameInfo> {

	@Override public boolean shouldMerge(StowotmInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StowotmInfo> merge(StowotmInfo baseInfo, UsernameInfo selectedInfo) {
		List<StowotmInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
