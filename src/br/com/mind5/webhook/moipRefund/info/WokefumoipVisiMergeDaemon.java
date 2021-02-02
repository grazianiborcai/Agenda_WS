package br.com.mind5.webhook.moipRefund.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class WokefumoipVisiMergeDaemon extends InfoMergerVisitorTemplate<WokefumoipInfo, UserInfo> {

	@Override public boolean shouldMerge(WokefumoipInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<WokefumoipInfo> merge(WokefumoipInfo baseInfo, UserInfo selectedInfo) {
		List<WokefumoipInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}
