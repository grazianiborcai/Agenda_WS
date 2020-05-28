package br.com.mind5.business.employeeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplisCopySchedmon extends InfoCopierOneToManyTemplate<EmplisInfo, SchedmonInfo> {
	
	public EmplisCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<EmplisInfo> makeCopyHook(SchedmonInfo source) {
		List<EmplisInfo> results = new ArrayList<>();
		
		if (source.schedonthates == null)
			return results;
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthates) {
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
