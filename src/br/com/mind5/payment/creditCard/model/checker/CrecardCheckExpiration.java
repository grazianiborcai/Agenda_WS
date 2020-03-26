package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckExpiration extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckExpiration(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.expirationMonth	== null ||
			recordInfo.expirationYear 	== null		)	
			
			return super.FAILED;
		
		
		if (checkMonthLength(recordInfo.expirationMonth)	== false ||
			checkYearLength(recordInfo.expirationYear) 		== false ||
			checkOnlyNumber(recordInfo.expirationMonth)		== false ||
			checkOnlyNumber(recordInfo.expirationYear) 		== false)
			
			return false;
		
		
		if (checkMonth(recordInfo.expirationMonth)									== false ||
			checkYear(recordInfo.expirationYear) 									== false ||
			checkYearMonth(recordInfo.expirationYear, recordInfo.expirationMonth) 	== false)
				
			return false;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkMonthLength(String month) {
		if (month.length() == 2)			
			return true;	
		
		return false;
	}
	
	
	
	private boolean checkYearLength(String year) {
		if (year.length() == 4)			
			return true;	
		
		return false;
	}
	
	
	
	private boolean checkOnlyNumber(String value) {
		if (value.matches("^\\d+$"))			
			return true;	
		
		return false;
	}
	
	
	
	private boolean checkMonth(String month) {
		if (month.contentEquals("01") || month.contentEquals("02") ||
			month.contentEquals("03") || month.contentEquals("04") ||
			month.contentEquals("05") || month.contentEquals("06") ||
			month.contentEquals("07") || month.contentEquals("08") ||
			month.contentEquals("09") || month.contentEquals("10") ||
			month.contentEquals("11") || month.contentEquals("12") 		)
			
			return true;
		
		return false;
	}
	
	
	
	private boolean checkYear(String year) {
		int yearInt = parseToInt(year);		
		int now = LocalDate.now().getYear();
		
		if (yearInt >= now)
			return true;
		
		return false;
	}
	
	
	
	private boolean checkYearMonth(String year, String month) {
		int yearMonthInt = toYearMonth(year, month);	
		int nowYearMonthInt = getYearMonthNow();
		
		if (yearMonthInt >= nowYearMonthInt)
			return true;
		
		return false;
	}
	
	
	
	private int toYearMonth(String year, String month) {
		String yearMonth = year + month;
		return parseToInt(yearMonth);
	}
	
	
	
	private int getYearMonthNow() {
		String nowYear = String.valueOf(LocalDate.now().getYear());
		String nowMonth = "0" + String.valueOf(LocalDate.now().getMonthValue());
		nowMonth = nowMonth.substring(nowMonth.length()-2, nowMonth.length());
		String nowYearMonth = nowYear + nowMonth;
		return parseToInt(nowYearMonth);
	}
	
	
	
	private int parseToInt(String value) {
		try {
			return Integer.parseInt(value);
			
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_INVALID_EXPIRY_DATE;
	}
}
