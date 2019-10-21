package br.com.mind5.business.planingData.info;

import br.com.mind5.common.TimeAge;
import br.com.mind5.info.InfoPrunerSelfVisitor;

final class PlanataVisiPruneAged implements InfoPrunerSelfVisitor<PlanataInfo> {

	@Override public PlanataInfo pruneRecord(PlanataInfo source) {
		if (isAged(source))
			return null;

		return source;
	}
	
	
	
	private boolean isAged(PlanataInfo source) {
		TimeAge timeAge = new TimeAge();
		return timeAge.isAged(source.date, source.endTime);		
	}

	

	@Override public boolean shouldPrune(PlanataInfo source) {
		return true;
	}
}
