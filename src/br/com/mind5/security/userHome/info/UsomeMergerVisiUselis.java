package br.com.mind5.security.userHome.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class UsomeMergerVisiUselis extends InfoMergerVisitorTemplate<UsomeInfo, UselisInfo> {
	
	@Override public boolean shouldMerge(UsomeInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser);
	}	
	
	

	@Override public List<UsomeInfo> merge(UsomeInfo baseInfo, UselisInfo selectedInfo) {
		List<UsomeInfo> results = new ArrayList<>();	
		
		baseInfo.codPerson  = selectedInfo.codPerson;
		baseInfo.fimistData = selectedInfo.fimistData;
		
		if (selectedInfo.persolisData != null) {
			baseInfo.name = selectedInfo.persolisData.name;
			baseInfo.nameDisplay = selectedInfo.persolisData.nameDisplay;
		}
		
		results.add(baseInfo);
		return results;
	}
}
