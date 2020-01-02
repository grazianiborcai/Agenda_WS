package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoPrunerVisitor;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PlanataVisiPruneStopar implements InfoPrunerVisitor<PlanataInfo, StoparInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, StoparInfo selectedInfo) {
		
		if (selectedInfo.idPayPartnerStore == null)
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(PlanataInfo baseInfo, StoparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
}
