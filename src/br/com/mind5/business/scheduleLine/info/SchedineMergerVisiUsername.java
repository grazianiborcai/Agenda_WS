package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class SchedineMergerVisiUsername extends InfoMergerVisitorTemplate<SchedineInfo, UsernameInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, UsernameInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
