package br.com.mind5.business.storeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StolisCopySchedeek extends InfoCopierOneToManyTemplate<StolisInfo, SchedeekInfo> {
	
	public StolisCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(SchedeekInfo source) {
		List<StolisInfo> results = new ArrayList<>();
		
		if (source.schedeekdats == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdats) {
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
