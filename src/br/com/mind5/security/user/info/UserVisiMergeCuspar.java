package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class UserVisiMergeCuspar extends InfoMergerVisitorTemplate<UserInfo, CusparInfo> {
	
	@Override public boolean shouldMerge(UserInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	

	@Override public List<UserInfo> merge(UserInfo baseInfo, CusparInfo selectedInfo) {
		List<UserInfo> results = new ArrayList<>();
		
		baseInfo.cuspars.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserInfo> getUniquifier() {
		return new UserUniquifier();
	}
}
