package br.com.mind5.security.userHome.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class UsomeMergerVisiUsername extends InfoMergerVisitorTemplate<UsomeInfo, UsernameInfo> {
	
	@Override public boolean shouldMerge(UsomeInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.username.equals(selectedInfo.username));
	}	
	
	

	@Override public List<UsomeInfo> merge(UsomeInfo baseInfo, UsernameInfo selectedInfo) {
		List<UsomeInfo> results = new ArrayList<>();
		UsomeInfo result;
		
		result = UsomeInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
