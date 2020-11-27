package br.com.mind5.business.customerList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class CuslisCopyScheday extends InfoCopierOneToManyTemplate<CuslisInfo, SchedayInfo> {
	
	public CuslisCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<CuslisInfo> makeCopyHook(SchedayInfo source) {
		List<CuslisInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedaytas : source.schedaytas) {
			CuslisInfo eachResult = new CuslisInfo();
			
			eachResult.codOwner = eachSchedaytas.codOwner;
			eachResult.codCustomer = eachSchedaytas.codCustomer;
			eachResult.codLanguage = eachSchedaytas.codLanguage;
			eachResult.username = eachSchedaytas.username;
			
			results.add(eachResult);
		}
		
		
		CuslisUniquifier uniquifier = new CuslisUniquifier();
		return uniquifier.uniquify(results);
	}
}
