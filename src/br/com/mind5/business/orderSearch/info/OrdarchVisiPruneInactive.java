package br.com.mind5.business.orderSearch.info;

import br.com.mind5.info.InfoPrunerSingleVisitor;
import br.com.mind5.masterData.orderStatus.info.Orderatus;

final class OrdarchVisiPruneInactive implements InfoPrunerSingleVisitor<OrdarchInfo, OrdarchInfo> {
	
	@Override public boolean pruneRecord(OrdarchInfo baseInfo, OrdarchInfo selectedInfo) {		
		if (baseInfo.codOrderStatus == null)
			return true;
		
		if (baseInfo.codOrderStatus.equals(Orderatus.CANCELLED.getCodStatus()))
			return true;
		
		return false;
	}

	
	
	@Override public boolean shouldPrune(OrdarchInfo baseInfo, OrdarchInfo selectedInfo) {
		return baseInfo.equals(selectedInfo);
	}
}
