package br.com.mind5.business.planingData.info;

import br.com.mind5.common.TimeAge;
import br.com.mind5.info.InfoPrunerSingleVisitor;

final class PlanataVisiPruneAged implements InfoPrunerSingleVisitor<PlanataInfo, PlanataInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, PlanataInfo selectedInfo) {
		
		if (isAged(baseInfo))
			return true;
		
		return false;
	}
	
	
	
	private boolean isAged(PlanataInfo baseInfo) {
		TimeAge timeAge = new TimeAge();
		return timeAge.isAged(baseInfo.date, baseInfo.endTime);		
	}



	@Override public boolean shouldPrune(PlanataInfo baseInfo, PlanataInfo selectedInfo) {
		return baseInfo.equals(selectedInfo);
	}
}
