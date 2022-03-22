package br.com.mind5.bot.botStats.botStatsCustomer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class BostusMergerVisiDaemon extends InfoMergerVisitorTemplate<BostusInfo, UserInfo> {

	@Override public boolean shouldMerge(BostusInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostusInfo> merge(BostusInfo baseInfo, UserInfo selectedInfo) {
		List<BostusInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}
