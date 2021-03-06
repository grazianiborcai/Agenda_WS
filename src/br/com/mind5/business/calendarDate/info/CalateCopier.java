package br.com.mind5.business.calendarDate.info;


import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;

public final class CalateCopier {	
	public static CalateInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<CalateInfo, PlanataInfo> copier = new CalateCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CalateInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<CalateInfo, PlanataInfo> copier = new CalateCopyPlanata();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CalateInfo copyFromCaleekyNext(CaleekyInfo source) {
		InfoCopier<CalateInfo, CaleekyInfo> copier = new CalateCopyCaleekyNext();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CalateInfo> copyFromCaleekyNext(List<CaleekyInfo> sources) {
		InfoCopier<CalateInfo, CaleekyInfo> copier = new CalateCopyCaleekyNext();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CalateInfo copyFromCaleekyPrevious(CaleekyInfo source) {
		InfoCopier<CalateInfo, CaleekyInfo> copier = new CalateCopyCaleekyPrevious();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CalateInfo> copyFromCaleekyPrevious(List<CaleekyInfo> sources) {
		InfoCopier<CalateInfo, CaleekyInfo> copier = new CalateCopyCaleekyPrevious();
		return copier.makeCopy(sources);
	}
}
