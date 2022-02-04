package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SuseraciveVisiMergeMonth extends InfoMergerVisitorTemplate<SuseraciveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SuseraciveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SuseraciveInfo> merge(SuseraciveInfo baseInfo, MonthInfo selectedInfo) {
		List<SuseraciveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
