package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class SchedauthVisiMergeUsername extends InfoMergerVisitorTemplate<SchedauthInfo, UsernameInfo> {

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
}
