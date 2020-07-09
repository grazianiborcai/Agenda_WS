package br.com.mind5.authorization.customerAuthorization.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

final class CusauthVisiMergeStorauth implements InfoMergerVisitorV3<CusauthInfo, StorauthInfo> {

	@Override public List<CusauthInfo> beforeMerge(List<CusauthInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusauthInfo baseInfo, StorauthInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<CusauthInfo> merge(CusauthInfo baseInfo, StorauthInfo selectedInfo) {
		List<CusauthInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusauthInfo> getUniquifier() {
		return null;
	}
}
