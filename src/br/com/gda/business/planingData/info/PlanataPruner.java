package br.com.gda.business.planingData.info;

import java.util.List;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.info.InfoPruner;
import br.com.gda.info.InfoPrunerSelf;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class PlanataPruner {
	public static List<PlanataInfo> pruneWithStopar(List<PlanataInfo> sourceOne, List<StoparInfo> sourceTwo) {
		InfoPruner<PlanataInfo, StoparInfo> pruner = new PlanataPrunerStopar();		
		return pruner.prune(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> pruneWithEmplevate(List<PlanataInfo> sourceOne, List<EmplevateInfo> sourceTwo) {
		InfoPruner<PlanataInfo, EmplevateInfo> pruner = new PlanataPrunerEmplevate();		
		return pruner.prune(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> pruneWithStolevate(List<PlanataInfo> sourceOne, List<StolevateInfo> sourceTwo) {
		InfoPruner<PlanataInfo, StolevateInfo> pruner = new PlanataPrunerStolevate();		
		return pruner.prune(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> pruneAged(List<PlanataInfo> source) {
		InfoPrunerSelf<PlanataInfo> pruner = new PlanataPrunerAged();		
		return pruner.prune(source);
	}
	
	
	
	public static List<PlanataInfo> pruneWithCarterve(List<PlanataInfo> sourceOne, List<CarterveInfo> sourceTwo) {
		InfoPruner<PlanataInfo, CarterveInfo> pruner = new PlanataPrunerCarterve();		
		return pruner.prune(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> pruneWithOrderve(List<PlanataInfo> sourceOne, List<OrderveInfo> sourceTwo) {
		InfoPruner<PlanataInfo, OrderveInfo> pruner = new PlanataPrunerOrderve();		
		return pruner.prune(sourceOne, sourceTwo);
	}	
}
