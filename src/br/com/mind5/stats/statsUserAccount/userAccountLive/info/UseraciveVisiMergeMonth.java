package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class UseraciveVisiMergeMonth extends InfoMergerVisitorTemplate<UseraciveInfo, MonthInfo> {

	@Override public boolean shouldMerge(UseraciveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<UseraciveInfo> merge(UseraciveInfo baseInfo, MonthInfo selectedInfo) {
		List<UseraciveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
