package br.com.mind5.bot.botStats.botStatsOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class BostowMergerVisiDaemon extends InfoMergerVisitorTemplate<BostowInfo, UserInfo> {

	@Override public boolean shouldMerge(BostowInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostowInfo> merge(BostowInfo baseInfo, UserInfo selectedInfo) {
		List<BostowInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}
