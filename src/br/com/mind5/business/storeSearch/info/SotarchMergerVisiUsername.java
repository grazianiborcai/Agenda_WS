package br.com.mind5.business.storeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class SotarchMergerVisiUsername extends InfoMergerVisitorTemplate<SotarchInfo, UsernameInfo> {

	@Override public boolean shouldMerge(SotarchInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<SotarchInfo> merge(SotarchInfo baseInfo, UsernameInfo selectedInfo) {
		List<SotarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
