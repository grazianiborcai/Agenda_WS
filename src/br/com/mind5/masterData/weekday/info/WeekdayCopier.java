package br.com.mind5.masterData.weekday.info;


import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class WeekdayCopier {	
	public static List<WeekdayInfo> copyFromCalgue(CalgueInfo source) {
		InfoCopierOneToMany<WeekdayInfo, CalgueInfo> copier = new WeekdayCopyCalgue();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromCalgue(List<CalgueInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, CalgueInfo> copier = new WeekdayCopyCalgue();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<WeekdayInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<WeekdayInfo, SchedeekInfo> copier = new WeekdayCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, SchedeekInfo> copier = new WeekdayCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<WeekdayInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<WeekdayInfo, SchedmonInfo> copier = new WeekdayCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, SchedmonInfo> copier = new WeekdayCopySchedmon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<WeekdayInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<WeekdayInfo, SchedayInfo> copier = new WeekdayCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, SchedayInfo> copier = new WeekdayCopyScheday();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<WeekdayInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<WeekdayInfo, PlanimeInfo> copier = new WeekdayCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<WeekdayInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<WeekdayInfo, PlanimeInfo> copier = new WeekdayCopyPlanime();
		return copier.makeCopy(sources);
	}
}
