package br.com.mind5.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class UpswdVisiMergeUsername extends InfoMergerVisitorTemplate<UpswdInfo, UsernameInfo> {
	
	@Override public List<UpswdInfo> beforeMerge(List<UpswdInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UpswdInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<UpswdInfo> merge(UpswdInfo baseInfo, UsernameInfo selectedInfo) {
		List<UpswdInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UpswdInfo> getUniquifier() {
		return null;
	}
}
