package br.com.mind5.webhook.moipMultipayment.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class WokaymoipVisiMergeDaemon extends InfoMergerVisitorTemplate<WokaymoipInfo, UserInfo> {

	@Override public boolean shouldMerge(WokaymoipInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<WokaymoipInfo> merge(WokaymoipInfo baseInfo, UserInfo selectedInfo) {
		List<WokaymoipInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}
