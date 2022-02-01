package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class StoraciveVisiMergeMonth extends InfoMergerVisitorTemplate<StoraciveInfo, MonthInfo> {

	@Override public boolean shouldMerge(StoraciveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<StoraciveInfo> merge(StoraciveInfo baseInfo, MonthInfo selectedInfo) {
		List<StoraciveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
