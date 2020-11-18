package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class EmpwotmVisiMergeWeekday extends InfoMergerVisitorTemplate<EmpwotmInfo, WeekdayInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, WeekdayInfo selectedInfo) {
		return (baseInfo.codWeekday == selectedInfo.codWeekday		&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, WeekdayInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.txtWeekday = selectedInfo.txtWeekday;
		
		results.add(baseInfo);
		return results;
	}
}
