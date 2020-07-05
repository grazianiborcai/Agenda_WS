package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class CusVisiMergeUser implements InfoMergerVisitorV3<CusInfo, UserInfo> {
	
	@Override public List<CusInfo> beforeMerge(List<CusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, UserInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.userData = selectedInfo;
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusInfo> getUniquifier() {
		return null;
	}
}
