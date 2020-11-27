package br.com.mind5.business.customerList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class CuslisCopySchedeek extends InfoCopierOneToManyTemplate<CuslisInfo, SchedeekInfo> {
	
	public CuslisCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<CuslisInfo> makeCopyHook(SchedeekInfo source) {
		List<CuslisInfo> results = new ArrayList<>();
		
		if (source.schedeekdates == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdates) {
			CuslisInfo eachResult = new CuslisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codCustomer = eachSchedonthat.codCustomer;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		CuslisUniquifier uniquifier = new CuslisUniquifier();
		return uniquifier.uniquify(results);
	}
}
