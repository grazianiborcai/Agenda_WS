package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class MatCopier {
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
}
