package br.com.mind5.masterData.month.info;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MonthCopier {
	public static List<MonthInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<MonthInfo, SchedayInfo> copier = new MonthCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MonthInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<MonthInfo, SchedayInfo> copier = new MonthCopyScheday();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<MonthInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<MonthInfo, SchedmonInfo> copier = new MonthCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MonthInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<MonthInfo, SchedmonInfo> copier = new MonthCopySchedmon();
		return copier.makeCopy(sources);
	}	
}
