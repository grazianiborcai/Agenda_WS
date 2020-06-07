package br.com.mind5.business.calendarTimeEmployee.info;


import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class CalimempCopier {
	public static List<CalimempInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<CalimempInfo, SchedeekInfo> copier = new CalimempCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CalimempInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<CalimempInfo, SchedeekInfo> copier = new CalimempCopySchedeek();
		return copier.makeCopy(sources);
	}
}
