package br.com.mind5.business.storeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StolisCopySchedyear extends InfoCopierOneToManyTemplate<StolisInfo, SchedyearInfo> {
	
	public StolisCopySchedyear() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(SchedyearInfo source) {
		List<StolisInfo> results = new ArrayList<>();
		
		if (source.schedyerates == null)
			return results;
		
		
		for (SchedyeratInfo eachSchedyerat : source.schedyerates) {
			StolisInfo eachResult = new StolisInfo();
			
			eachResult.codOwner = eachSchedyerat.codOwner;
			eachResult.codStore = eachSchedyerat.codStore;
			eachResult.codLanguage = eachSchedyerat.codLanguage;
			eachResult.username = eachSchedyerat.username;
			
			results.add(eachResult);
		}
		
		
		StolisUniquifier uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
