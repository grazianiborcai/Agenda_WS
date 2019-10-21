package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class MatCopier {
	public static List<MatInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<MatInfo, SchedeekInfo> copier = new MatCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<MatInfo, SchedeekInfo> copier = new MatCopySchedeek();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<MatInfo> copyFromSchedmon(SchedmonInfo source) {
		InfoCopierOneToMany<MatInfo, SchedmonInfo> copier = new MatCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopierOneToMany<MatInfo, SchedmonInfo> copier = new MatCopySchedmon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatInfo copyFromOrdemrap(OrdemrapInfo source) {
		InfoCopier<MatInfo, OrdemrapInfo> copier = new MatCopyOrdemrap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromOrdemrap(List<OrdemrapInfo> sources) {
		InfoCopier<MatInfo, OrdemrapInfo> copier = new MatCopyOrdemrap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatInfo copyFromSchedinap(SchedinapInfo source) {
		InfoCopier<MatInfo, SchedinapInfo> copier = new MatCopySchedinap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromSchedinap(List<SchedinapInfo> sources) {
		InfoCopier<MatInfo, SchedinapInfo> copier = new MatCopySchedinap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatInfo copyFromSchedine(SchedineInfo source) {
		InfoCopier<MatInfo, SchedineInfo> copier = new MatCopySchedine();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<MatInfo, SchedineInfo> copier = new MatCopySchedine();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<MatInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<MatInfo, PlanimeInfo> copier = new MatCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<MatInfo, PlanimeInfo> copier = new MatCopyPlanime();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatInfo copyFromCartem(CartemInfo source) {
		InfoCopier<MatInfo, CartemInfo> copier = new MatCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopier<MatInfo, CartemInfo> copier = new MatCopyCartem();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatInfo copyFromOrderem(OrderemInfo source) {
		InfoCopier<MatInfo, OrderemInfo> copier = new MatCopyOrderem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatInfo> copyFromOrderem(List<OrderemInfo> sources) {
		InfoCopier<MatInfo, OrderemInfo> copier = new MatCopyOrderem();
		return copier.makeCopy(sources);
	}	
}
