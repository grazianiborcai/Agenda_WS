package br.com.mind5.business.calendarMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalonthMergerVisiToSelect extends InfoMergerVisitorTemplate<CalonthInfo, CalonthInfo> {

	@Override public boolean shouldMerge(CalonthInfo baseInfo, CalonthInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalonthInfo> merge(CalonthInfo baseInfo, CalonthInfo selectedInfo) {
		List<CalonthInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
