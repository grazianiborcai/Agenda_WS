package br.com.gda.business.storeList.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class StolisCopier {
	public static List<StolisInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<StolisInfo, SchedeekInfo> copier = new StolisCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<StolisInfo, SchedeekInfo> copier = new StolisCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<StolisInfo, SchedmonInfo> copier = new StolisCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<StolisInfo, SchedmonInfo> copier = new StolisCopySchedmon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedyear(SchedyearInfo source) {
		InfoCopierOneToMany<StolisInfo, SchedyearInfo> copier = new StolisCopySchedyear();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedyear(List<SchedyearInfo> sources) {
		InfoCopierOneToMany<StolisInfo, SchedyearInfo> copier = new StolisCopySchedyear();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<StolisInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<StolisInfo, PlanimeInfo> copier = new StolisCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<StolisInfo, PlanimeInfo> copier = new StolisCopyPlanime();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StolisInfo copyFromSchedine(SchedineInfo source) {
		InfoCopier<StolisInfo, SchedineInfo> copier = new StolisCopySchedine();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<StolisInfo, SchedineInfo> copier = new StolisCopySchedine();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StolisInfo copyFromAddresnap(AddresnapInfo source) {
		InfoCopier<StolisInfo, AddresnapInfo> copier = new StolisCopyAddresnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<StolisInfo, AddresnapInfo> copier = new StolisCopyAddresnap();
		return copier.makeCopy(sources);
	}
}
