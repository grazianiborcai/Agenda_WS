package br.com.mind5.business.employeeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplisCopySchedeek extends InfoCopierOneToManyTemplate<EmplisInfo, SchedeekInfo>{
	
	public EmplisCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<EmplisInfo> makeCopyHook(SchedeekInfo source) {
		List<EmplisInfo> results = new ArrayList<>();
		
		if (source.schedeekdats == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdats) {
			EmplisInfo eachResult = new EmplisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codEmployee = eachSchedonthat.codEmployee;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		EmplisUniquifier uniquifier = new EmplisUniquifier();
		return uniquifier.uniquify(results);
	}
}
