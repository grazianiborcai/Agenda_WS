package br.com.mind5.common;

import java.time.LocalDate;
import java.time.Period;

import br.com.mind5.model.checker.ModelCheckerOption;

public final class DateValidator {
	static private final boolean SUCCESS = ModelCheckerOption.SUCCESS;
	static private final boolean FAILED = ModelCheckerOption.FAILED;
	
	
	static public boolean validateBirthdate(LocalDate birthDate) {
		if (birthDate == null)
			return FAILED;
		
		if (checkDate(birthDate) == FAILED)
			return FAILED;
		
		if (checkFuture(birthDate) == FAILED)
			return FAILED;		
		
		if (check120Year(birthDate) == FAILED)			
			return FAILED;
		
		
		return SUCCESS;		
	}
	
	
	
	static private boolean checkDate(LocalDate date) {
		try {
			int year  = date.getYear();
			int month = date.getMonthValue();
			int day   = date.getDayOfMonth();
			
			LocalDate.of(year, month, day);			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	static private boolean checkFuture(LocalDate date) {
		LocalDate now = DefaultValue.localDateNow();
		
		if (date.isAfter(now) ||
			date.isEqual(now)		)
			return FAILED;
		
		return SUCCESS;
	}
	
	
	
	static private boolean check120Year(LocalDate date) {
		LocalDate now = DefaultValue.localDateNow();
		
		Period period = Period.between(now, date);
	    int diff = Math.abs(period.getYears());
	    
	    if (diff > 120)
	    	return FAILED;
		
		return SUCCESS;
	}
}
