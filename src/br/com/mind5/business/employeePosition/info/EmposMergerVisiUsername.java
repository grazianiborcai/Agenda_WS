package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmposMergerVisiUsername extends InfoMergerVisitorTemplate<EmposInfo, UsernameInfo> {

	@Override public boolean shouldMerge(EmposInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, UsernameInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}

}
