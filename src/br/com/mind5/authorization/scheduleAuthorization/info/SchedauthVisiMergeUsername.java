package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class SchedauthVisiMergeUsername implements InfoMergerVisitorV3<SchedauthInfo, UsernameInfo> {
	
	@Override public List<SchedauthInfo> beforeMerge(List<SchedauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedauthInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<SchedauthInfo> merge(SchedauthInfo baseInfo, UsernameInfo selectedInfo) {
		List<SchedauthInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedauthInfo> getUniquifier() {
		return null;
	}
}
