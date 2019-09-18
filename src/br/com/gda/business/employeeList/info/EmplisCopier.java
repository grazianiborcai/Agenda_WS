package br.com.gda.business.employeeList.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class EmplisCopier {
	public static List<EmplisInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<EmplisInfo, SchedeekInfo> copier = new EmplisCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<EmplisInfo, SchedeekInfo> copier = new EmplisCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<EmplisInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<EmplisInfo, SchedmonInfo> copier = new EmplisCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<EmplisInfo, SchedmonInfo> copier = new EmplisCopySchedmon();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<EmplisInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<EmplisInfo, PlanimeInfo> copier = new EmplisCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<EmplisInfo, PlanimeInfo> copier = new EmplisCopyPlanime();
		return copier.makeCopy(sources);
	}
	
	
	
	public static EmplisInfo copyFromSchedine(SchedineInfo source) {
		InfoCopier<EmplisInfo, SchedineInfo> copier = new EmplisCopySchedine();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<EmplisInfo, SchedineInfo> copier = new EmplisCopySchedine();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static EmplisInfo copyFromAddresnap(AddresnapInfo source) {
		InfoCopier<EmplisInfo, AddresnapInfo> copier = new EmplisCopyAddresnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<EmplisInfo, AddresnapInfo> copier = new EmplisCopyAddresnap();
		return copier.makeCopy(sources);
	}	
}
