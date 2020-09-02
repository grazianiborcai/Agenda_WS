package br.com.mind5.business.calendarCatalogueData.info;

import java.time.LocalDate;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoPrunerSingleVisitor;

final class CalguataVisiPruneAged implements InfoPrunerSingleVisitor<CalguataInfo, CalguataInfo> {
	
	@Override public boolean pruneRecord(CalguataInfo baseInfo, CalguataInfo selectedInfo) {
		if (baseInfo.date == null)
			return true;
		
		return isAged(baseInfo);
	}
	
	
	
	private boolean isAged(CalguataInfo baseInfo) {
		LocalDate now = DefaultValue.localDateNow();
		
		return baseInfo.date.isBefore(now);	
	}



	@Override public boolean shouldPrune(CalguataInfo baseInfo, CalguataInfo selectedInfo) {
		return baseInfo.equals(selectedInfo);
	}
}
