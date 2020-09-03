package br.com.mind5.masterData.dayParting.info;


import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class DaypartCopier {
	public static List<DaypartInfo> copyFromCalgue(CalgueInfo source) {
		InfoCopierOneToMany<DaypartInfo, CalgueInfo> copier = new DaypartCopyCalgue();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<DaypartInfo> copyFromCalgue(List<CalgueInfo> sources) {
		InfoCopierOneToMany<DaypartInfo, CalgueInfo> copier = new DaypartCopyCalgue();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<DaypartInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<DaypartInfo, PlanimeInfo> copier = new DaypartCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<DaypartInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<DaypartInfo, PlanimeInfo> copier = new DaypartCopyPlanime();
		return copier.makeCopy(sources);
	}
}
