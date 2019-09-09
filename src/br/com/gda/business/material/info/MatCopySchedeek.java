package br.com.gda.business.material.info;


import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class MatCopySchedeek extends InfoCopierOneToManyTemplate<MatInfo, SchedeekInfo>{
	
	public MatCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<MatInfo> makeCopyHook(SchedeekInfo source) {
		List<MatInfo> results = new ArrayList<>();
		
		if (source.schedeekdats == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdats) {
			MatInfo eachResult = new MatInfo();
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codMat = eachSchedonthat.codMat;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		MatUniquifier uniquifier = new MatUniquifier();
		return uniquifier.uniquify(results);
	}
}
