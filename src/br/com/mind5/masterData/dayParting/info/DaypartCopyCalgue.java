package br.com.mind5.masterData.dayParting.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class DaypartCopyCalgue extends InfoCopierOneToManyTemplate<DaypartInfo, CalgueInfo> {
	
	public DaypartCopyCalgue() {
		super();
	}
	
	
	
	@Override protected List<DaypartInfo> makeCopyHook(CalgueInfo source) {
		Set<DaypartInfo> results = new HashSet<>();
		
		for (CalguataInfo eachCalguata : source.calguatas) {
			DaypartInfo oneResult = new DaypartInfo();
			oneResult.codDaypart = eachCalguata.codDaypart;
			
			results.add(oneResult);
		}
		
		return new ArrayList<>(results);
	}
}
