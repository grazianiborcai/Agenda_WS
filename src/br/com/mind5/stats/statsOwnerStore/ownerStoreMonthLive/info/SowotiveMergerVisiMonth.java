package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SowotiveMergerVisiMonth extends InfoMergerVisitorTemplate<SowotiveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SowotiveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowotiveInfo> merge(SowotiveInfo baseInfo, MonthInfo selectedInfo) {
		List<SowotiveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
