package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SowaliveVisiMergeMonth extends InfoMergerVisitorTemplate<SowaliveInfo, MonthInfo> {

	@Override public boolean shouldMerge(SowaliveInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SowaliveInfo> merge(SowaliveInfo baseInfo, MonthInfo selectedInfo) {
		List<SowaliveInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
}
