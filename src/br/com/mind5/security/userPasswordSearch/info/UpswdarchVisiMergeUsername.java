package br.com.mind5.security.userPasswordSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class UpswdarchVisiMergeUsername extends InfoMergerVisitorTemplate<UpswdarchInfo, UsernameInfo> {
	
	@Override public List<UpswdarchInfo> beforeMerge(List<UpswdarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<UpswdarchInfo> getUniquifier() {
		return null;
	}
}
