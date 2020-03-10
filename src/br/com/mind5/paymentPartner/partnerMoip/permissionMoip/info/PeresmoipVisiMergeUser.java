package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class PeresmoipVisiMergeUser implements InfoMergerVisitorV3<PeresmoipInfo, UserInfo> {
	
	@Override public List<PeresmoipInfo> beforeMerge(List<PeresmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PeresmoipInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PeresmoipInfo> merge(PeresmoipInfo baseInfo, UserInfo selectedInfo) {
		List<PeresmoipInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PeresmoipInfo> getUniquifier() {
		return null;
	}
}
