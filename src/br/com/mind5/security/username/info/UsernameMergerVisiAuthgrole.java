package br.com.mind5.security.username.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

final class UsernameMergerVisiAuthgrole extends InfoMergerVisitorTemplate<UsernameInfo, AuthgroleInfo> {

	@Override public boolean shouldMerge(UsernameInfo baseInfo, AuthgroleInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<UsernameInfo> merge(UsernameInfo baseInfo, AuthgroleInfo selectedInfo) {
		List<UsernameInfo> results = new ArrayList<>();
		
		baseInfo.authgroles.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UsernameInfo> uniquifyHook(List<UsernameInfo> results) {
		InfoUniquifier<UsernameInfo> uniquifier = new UsernameUniquifier();		
		return uniquifier.uniquify(results);
	}
}
