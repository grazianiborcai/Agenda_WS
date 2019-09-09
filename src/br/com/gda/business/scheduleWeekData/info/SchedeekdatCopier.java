package br.com.gda.business.scheduleWeekData.info;

import java.util.List;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.info.InfoCopier;

public final class SchedeekdatCopier {
	public static SchedeekdatInfo copyFromSchedeek(SchedeekInfo source) {
		InfoCopier<SchedeekdatInfo, SchedeekInfo> copier = new SchedeekdatCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedeekdatInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopier<SchedeekdatInfo, SchedeekInfo> copier = new SchedeekdatCopySchedeek();
		return copier.makeCopy(sources);
	}
}
