package br.com.mind5.business.storeLeaveDateRange.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolargCopyCalimore extends InfoCopierTemplate<StolargInfo, CalimoreInfo> {
	
	public StolargCopyCalimore() {
		super(new StolargUniquifier());
	}
	
	
	
	@Override protected StolargInfo makeCopyHook(CalimoreInfo source) {
		StolargInfo result = new StolargInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;		
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());		
		result.timeValidFrom = LocalTime.of(0, 0);
		result.timeValidTo = LocalTime.of(23, 59);		
		result.validFrom = LocalDateTime.of(result.dateValidFrom, result.timeValidFrom);
		result.validTo = LocalDateTime.of(result.dateValidTo, result.timeValidTo);		
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
