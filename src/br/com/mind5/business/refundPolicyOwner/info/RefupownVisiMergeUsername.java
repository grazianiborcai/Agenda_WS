package br.com.mind5.business.refundPolicyOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class RefupownVisiMergeUsername extends InfoMergerVisitorTemplate<RefupownInfo, UsernameInfo> {

	@Override public boolean shouldMerge(RefupownInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<RefupownInfo> merge(RefupownInfo baseInfo, UsernameInfo selectedInfo) {
		List<RefupownInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
