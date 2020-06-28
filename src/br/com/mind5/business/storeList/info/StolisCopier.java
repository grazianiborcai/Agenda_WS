package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class StolisCopier {
	public static StolisInfo copyFromAddresnap(AddresnapInfo source) {
		InfoCopier<StolisInfo, AddresnapInfo> copier = new StolisCopyAddresnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<StolisInfo, AddresnapInfo> copier = new StolisCopyAddresnap();
		return copier.makeCopy(sources);
	}
	
	
	
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
	
	
	
	public static StolisInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<StolisInfo, OwnerInfo> copier = new StolisCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<StolisInfo, OwnerInfo> copier = new StolisCopyOwner();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static StolisInfo copyFromPhonap(PhonapInfo source) {
		InfoCopier<StolisInfo, PhonapInfo> copier = new StolisCopyPhonap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromPhonap(List<PhonapInfo> sources) {
		InfoCopier<StolisInfo, PhonapInfo> copier = new StolisCopyPhonap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<StolisInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<StolisInfo, SchedayInfo> copier = new StolisCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolisInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<StolisInfo, SchedayInfo> copier = new StolisCopyScheday();
		return copier.makeCopy(sources);
	}
}
