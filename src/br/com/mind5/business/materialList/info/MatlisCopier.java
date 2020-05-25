package br.com.mind5.business.materialList.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MatlisCopier {
	public static List<MatlisInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<MatlisInfo, SchedeekInfo> copier = new MatlisCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<MatlisInfo, SchedeekInfo> copier = new MatlisCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<MatlisInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<MatlisInfo, SchedmonInfo> copier = new MatlisCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<MatlisInfo, SchedmonInfo> copier = new MatlisCopySchedmon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatlisInfo copyFromOrdemrap(OrdemrapInfo source) {
		InfoCopier<MatlisInfo, OrdemrapInfo> copier = new MatlisCopyOrdemrap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromOrdemrap(List<OrdemrapInfo> sources) {
		InfoCopier<MatlisInfo, OrdemrapInfo> copier = new MatlisCopyOrdemrap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatlisInfo copyFromSchedinap(SchedinapInfo source) {
		InfoCopier<MatlisInfo, SchedinapInfo> copier = new MatlisCopySchedinap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromSchedinap(List<SchedinapInfo> sources) {
		InfoCopier<MatlisInfo, SchedinapInfo> copier = new MatlisCopySchedinap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatlisInfo copyFromSchedine(SchedineInfo source) {
		InfoCopier<MatlisInfo, SchedineInfo> copier = new MatlisCopySchedine();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<MatlisInfo, SchedineInfo> copier = new MatlisCopySchedine();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<MatlisInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<MatlisInfo, PlanimeInfo> copier = new MatlisCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<MatlisInfo, PlanimeInfo> copier = new MatlisCopyPlanime();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatlisInfo copyFromCartem(CartemInfo source) {
		InfoCopier<MatlisInfo, CartemInfo> copier = new MatlisCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopier<MatlisInfo, CartemInfo> copier = new MatlisCopyCartem();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatlisInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<MatlisInfo, OrderemInfo> copier = new MatlisCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<MatlisInfo, OrderemInfo> copier = new MatlisCopyOrderem();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<MatlisInfo> copyFromScheday(SchedayInfo source) {
		InfoCopierOneToMany<MatlisInfo, SchedayInfo> copier = new MatlisCopyScheday();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatlisInfo> copyFromScheday(List<SchedayInfo> sources) {
		InfoCopierOneToMany<MatlisInfo, SchedayInfo> copier = new MatlisCopyScheday();
		return copier.makeCopy(sources);
	}	
}
