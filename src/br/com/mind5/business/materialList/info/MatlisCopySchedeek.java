package br.com.mind5.business.materialList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatlisCopySchedeek extends InfoCopierOneToManyTemplate<MatlisInfo, SchedeekInfo>{
	
	public MatlisCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<MatlisInfo> makeCopyHook(SchedeekInfo source) {
		List<MatlisInfo> results = new ArrayList<>();
		
		if (source.schedeekdats == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdats) {
			MatlisInfo eachResult = new MatlisInfo();
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codMat = eachSchedonthat.codMat;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		MatlisUniquifier uniquifier = new MatlisUniquifier();
		return uniquifier.uniquify(results);
	}
}
