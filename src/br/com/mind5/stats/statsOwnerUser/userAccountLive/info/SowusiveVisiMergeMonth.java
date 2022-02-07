package br.com.mind5.stats.statsOwnerUser.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SowusiveVisiMergeMonth extends InfoMergerVisitorTemplate<SowusiveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SowusiveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowusiveInfo> merge(SowusiveInfo baseInfo, MonthInfo selectedInfo) {
		List<SowusiveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
