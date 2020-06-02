package br.com.mind5.business.calendarTimeStore.info;


import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class CalimoreCopier {
	public static List<CalimoreInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<CalimoreInfo, SchedeekInfo> copier = new CalimoreCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CalimoreInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<CalimoreInfo, SchedeekInfo> copier = new CalimoreCopySchedeek();
		return copier.makeCopy(sources);
	}
}
