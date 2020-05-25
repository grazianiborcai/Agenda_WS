package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class EmplisCopier {
	public static EmplisInfo copyFromScheday(SchedayInfo source) {
		InfoCopier<EmplisInfo, SchedayInfo> copier = new EmplisCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopier<EmplisInfo, SchedayInfo> copier = new EmplisCopyScheday();
		return copier.makeCopy(sources);
	}
	
	
	
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
	
	
	
	public static EmplisInfo copyFromPhonap(PhonapInfo source) {
		InfoCopier<EmplisInfo, PhonapInfo> copier = new EmplisCopyPhonap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromPhonap(List<PhonapInfo> sources) {
		InfoCopier<EmplisInfo, PhonapInfo> copier = new EmplisCopyPhonap();
		return copier.makeCopy(sources);
	}		
	
	
	
	public static EmplisInfo copyFromEmpwout(EmpwoutInfo source) {
		InfoCopier<EmplisInfo, EmpwoutInfo> copier = new EmplisCopyEmpwout();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplisInfo> copyFromEmpwout(List<EmpwoutInfo> sources) {
		InfoCopier<EmplisInfo, EmpwoutInfo> copier = new EmplisCopyEmpwout();
		return copier.makeCopy(sources);
	}		
}
