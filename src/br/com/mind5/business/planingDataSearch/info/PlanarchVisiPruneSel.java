package br.com.mind5.business.planingDataSearch.info;

import br.com.mind5.info.InfoPrunerVisitor;

final class PlanarchVisiPruneSel implements InfoPrunerVisitor<PlanarchInfo, PlanarchInfo> {
	
	@Override public boolean pruneRecord(PlanarchInfo baseInfo, PlanarchInfo selectedInfo) {		
		if (baseInfo.beginTimeSel.equals(baseInfo.beginTime) == false)
			return true;
		
		if (baseInfo.endTimeSel.equals(baseInfo.endTime) == false)
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(PlanarchInfo baseInfo, PlanarchInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.date);
	}
}
