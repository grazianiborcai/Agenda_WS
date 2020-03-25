package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoPrunerSingleVisitor;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

final class PlanataVisiPruneStoplis implements InfoPrunerSingleVisitor<PlanataInfo, StoplisInfo> {
	
	@Override public boolean pruneRecord(PlanataInfo baseInfo, StoplisInfo selectedInfo) {
		
		if (selectedInfo.idPayPartnerStore == null)
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(PlanataInfo baseInfo, StoplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
}
