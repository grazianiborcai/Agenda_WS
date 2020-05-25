package br.com.mind5.business.scheduleMonthData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedonthatVisiMergeMonth implements InfoMergerVisitorV3<SchedonthatInfo, MonthInfo> {
	
	@Override public List<SchedonthatInfo> beforeMerge(List<SchedonthatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedonthatInfo baseInfo, MonthInfo selectedInfo) {
		return (baseInfo.month == selectedInfo.month && 
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SchedonthatInfo> merge(SchedonthatInfo baseInfo, MonthInfo selectedInfo) {
		List<SchedonthatInfo> results = new ArrayList<>();
		
		baseInfo.txtMonth = selectedInfo.txtMonth;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedonthatInfo> getUniquifier() {
		return null;
	}
}
