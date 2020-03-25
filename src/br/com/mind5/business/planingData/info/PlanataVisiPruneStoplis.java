package br.com.mind5.business.planingData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoPrunerListVisitor;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

final class PlanataVisiPruneStoplis implements InfoPrunerListVisitor<PlanataInfo, StoplisInfo> {
	
	@Override public List<PlanataInfo> pruneRecord(List<PlanataInfo> baseInfos, List<StoplisInfo> selectedInfos) {
		List<PlanataInfo> results = new ArrayList<>();
		
		for (PlanataInfo eachBase : baseInfos) {
			for (StoplisInfo eachSelected : selectedInfos) {
				if (eachSelected.codOwner == eachBase.codOwner &&
					eachSelected.codStore == eachBase.codStore &&
					eachSelected.idPayPartnerStore != null)
					
					results.add(eachBase);
			}
		}
		
		
		return results;
	}
}
