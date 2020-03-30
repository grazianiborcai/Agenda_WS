package br.com.mind5.business.storeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StolisCopySchedmon extends InfoCopierOneToManyTemplate<StolisInfo, SchedmonInfo>{
	
	public StolisCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(SchedmonInfo source) {
		List<StolisInfo> results = new ArrayList<>();
		
		if (source.schedonthats == null)
			return results;
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthats) {
			StolisInfo eachResult = new StolisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codStore = eachSchedonthat.codStore;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		StolisUniquifier uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
