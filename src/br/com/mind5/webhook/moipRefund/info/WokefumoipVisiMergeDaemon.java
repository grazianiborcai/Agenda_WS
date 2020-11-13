package br.com.mind5.webhook.moipRefund.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class WokefumoipVisiMergeDaemon implements InfoMergerVisitor<WokefumoipInfo, UserInfo> {
	
	@Override public List<WokefumoipInfo> beforeMerge(List<WokefumoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(WokefumoipInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<WokefumoipInfo> merge(WokefumoipInfo baseInfo, UserInfo selectedInfo) {
		List<WokefumoipInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<WokefumoipInfo> getUniquifier() {
		return null;
	}
}
