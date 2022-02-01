package br.com.mind5.business.calendarMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalonthVisiMergeCalontharch extends InfoMergerVisitorTemplate<CalonthInfo, CalontharchInfo> {

	@Override public boolean shouldMerge(CalonthInfo baseInfo, CalontharchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CalonthInfo> merge(CalonthInfo baseInfo, CalontharchInfo selectedInfo) {
		List<CalonthInfo> results = new ArrayList<>();
		
		CalonthInfo result = CalonthInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
