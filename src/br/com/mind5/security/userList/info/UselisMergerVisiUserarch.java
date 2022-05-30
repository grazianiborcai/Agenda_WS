package br.com.mind5.security.userList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class UselisMergerVisiUserarch extends InfoMergerVisitorTemplate<UselisInfo, UserarchInfo> {
	
	@Override public boolean shouldMerge(UselisInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<UselisInfo> merge(UselisInfo baseInfo, UserarchInfo selectedInfo) {
		List<UselisInfo> results = new ArrayList<>();
		
		UselisInfo result = UselisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
