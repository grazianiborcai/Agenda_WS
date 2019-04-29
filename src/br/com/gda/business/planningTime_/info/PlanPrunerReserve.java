package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.info.InfoPruner;

final class PlanPrunerReserve extends InfoPruner<PlanInfo, ReserveInfo> {
	public PlanInfo prune(PlanInfo sourceOne, ReserveInfo sourceTwo) {
		return super.prune(sourceOne, sourceTwo, new PlanPruneVisitorReserve());
	}
	
	
	
	public List<PlanInfo> prune(List<PlanInfo> sourceOnes, List<ReserveInfo> sourceTwos) {
		return super.prune(sourceOnes, sourceTwos, new PlanPruneVisitorReserve());
	}
}
