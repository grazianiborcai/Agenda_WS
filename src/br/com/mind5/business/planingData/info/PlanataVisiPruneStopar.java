package br.com.mind5.business.planingData.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoPrunerVisitor;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PlanataVisiPruneStopar implements InfoPrunerVisitor<PlanataInfo, StoparInfo> {
	
	@Override public PlanataInfo pruneRecord(PlanataInfo sourceOne, StoparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		if (hasStopar(sourceOne, sourceTwo))		
			return sourceOne;
		
		return null;
	}
	
	
	
	private boolean hasStopar(PlanataInfo planata, StoparInfo stopar) {		
		if (stopar == null)
			return false;
		
		if (stopar.idPayPartnerStore == null)
			return false;
		
		return true;
	}


	
	@Override public boolean shouldPrune(PlanataInfo sourceOne, StoparInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codStore == sourceTwo.codStore	);
	}
	
	
	
	private void checkArgument(PlanataInfo sourceOne, StoparInfo sourceTwo) {
		if (shouldPrune(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.PRUNE_NOT_ALLOWED);
	}
}
