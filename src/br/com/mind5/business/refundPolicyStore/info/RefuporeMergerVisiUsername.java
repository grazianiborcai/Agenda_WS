package br.com.mind5.business.refundPolicyStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class RefuporeMergerVisiUsername extends InfoMergerVisitorTemplate<RefuporeInfo, UsernameInfo> {

	@Override public boolean shouldMerge(RefuporeInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<RefuporeInfo> merge(RefuporeInfo baseInfo, UsernameInfo selectedInfo) {
		List<RefuporeInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
