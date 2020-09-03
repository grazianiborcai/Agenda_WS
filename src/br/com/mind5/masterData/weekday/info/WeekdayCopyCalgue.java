package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class WeekdayCopyCalgue extends InfoCopierOneToManyTemplate<WeekdayInfo, CalgueInfo> {
	
	public WeekdayCopyCalgue() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(CalgueInfo source) {
		Set<WeekdayInfo> results = new HashSet<>();
		
		for (CalguataInfo eachCalguata : source.calguatas) {
			WeekdayInfo oneResult = new WeekdayInfo();
			oneResult.codWeekday = eachCalguata.codWeekday;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
