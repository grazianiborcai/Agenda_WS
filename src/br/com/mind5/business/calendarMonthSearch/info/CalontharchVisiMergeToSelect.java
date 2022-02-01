package br.com.mind5.business.calendarMonthSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalontharchVisiMergeToSelect extends InfoMergerVisitorTemplate<CalontharchInfo, CalontharchInfo> {

	@Override public boolean shouldMerge(CalontharchInfo baseInfo, CalontharchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalontharchInfo> merge(CalontharchInfo baseInfo, CalontharchInfo selectedInfo) {
		List<CalontharchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
