package br.com.mind5.payment.creditCard.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CrecardSetterExpired extends InfoSetterTemplate<CrecardInfo> {
	
	@Override protected CrecardInfo setAttrHook(CrecardInfo recordInfo) {		
		int yearMonthExp = toYearMonth(recordInfo.expirationYear, recordInfo.expirationMonth);
		int yearMonthNow = now();
		
		recordInfo.isExpired = yearMonthNow >= yearMonthExp;
		return recordInfo;
	}
	
	
	
	private int toYearMonth(String expirationYear, String expirationMonth) {
		if (expirationYear == null)
			return 0;
		
		if (expirationMonth == null)
			return 0;
		
		String yearMonth = expirationYear + expirationMonth;
		return Integer.valueOf(yearMonth);
	}
	
	
	
	private int now() {
		LocalDate now = DefaultValue.localDateNow();
		String yearMonth = now.format(DateTimeFormatter.ofPattern("yyyyMM"));		
		return Integer.valueOf(yearMonth);
	}
}
