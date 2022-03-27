package br.com.mind5.business.employeeWorkTimeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class EmpwotmapMergerVisiWeekday extends InfoMergerVisitorTemplate<EmpwotmapInfo, WeekdayInfo> {
	
	@Override public boolean shouldMerge(EmpwotmapInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmpwotmapInfo> merge(EmpwotmapInfo baseInfo, WeekdayInfo selectedInfo) {
		List<EmpwotmapInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
