package br.com.mind5.business.scheduleWeekData.info;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopier;

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
