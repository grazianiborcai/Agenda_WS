package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UseraciveVisiMergeCalonth extends InfoMergerVisitorTemplate<UseraciveInfo, CalonthInfo> {

	@Override public boolean shouldMerge(UseraciveInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<UseraciveInfo> merge(UseraciveInfo baseInfo, CalonthInfo selectedInfo) {
		List<UseraciveInfo> results = new ArrayList<>();
		
		baseInfo.calmonth = selectedInfo.calmonth;
		baseInfo.year = selectedInfo.year;
		baseInfo.month = selectedInfo.month;
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
