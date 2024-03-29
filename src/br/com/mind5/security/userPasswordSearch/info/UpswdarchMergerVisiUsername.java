package br.com.mind5.security.userPasswordSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class UpswdarchMergerVisiUsername extends InfoMergerVisitorTemplate<UpswdarchInfo, UsernameInfo> {

	@Override public boolean shouldMerge(UpswdarchInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<UpswdarchInfo> merge(UpswdarchInfo baseInfo, UsernameInfo selectedInfo) {
		List<UpswdarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
