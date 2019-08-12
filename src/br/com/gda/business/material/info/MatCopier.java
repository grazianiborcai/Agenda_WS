package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class MatCopier {
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
