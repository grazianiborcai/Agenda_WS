package br.com.mind5.bot.botStats.botStatsStoreSchedule.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class BostodVisiMergeDaemon extends InfoMergerVisitorTemplate<BostodInfo, UserInfo> {

	@Override public boolean shouldMerge(BostodInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BostodInfo> merge(BostodInfo baseInfo, UserInfo selectedInfo) {
		List<BostodInfo> results = new ArrayList<>();
		
		baseInfo.username = selectedInfo.username;
		
		results.add(baseInfo);
		return results;
	}
}
