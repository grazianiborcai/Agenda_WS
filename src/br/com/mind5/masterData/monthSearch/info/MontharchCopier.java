package br.com.mind5.masterData.monthSearch.info;

import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.info.InfoCopier;

public final class MontharchCopier {
	public static MontharchInfo copyFromSchedyear(SchedyearInfo source) {
		InfoCopier<MontharchInfo, SchedyearInfo> copier = new MontharchCopySchedyear();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MontharchInfo> copyFromSchedyear(List<SchedyearInfo> sources) {
		InfoCopier<MontharchInfo, SchedyearInfo> copier = new MontharchCopySchedyear();
		return copier.makeCopy(sources);
	}
}
