package br.com.mind5.business.person.model.checker;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Period;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckBirthdate extends ModelCheckerTemplateSimple<PersonInfo> {

	public PersonCheckBirthdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.birthDate == null )			
			return super.SUCCESS;		
		
		
		if ( checkFuture(recordInfo.birthDate)  == super.FAILED ||
			 check120Year(recordInfo.birthDate) == super.FAILED	)			
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	
	private boolean checkFuture(LocalDate birthDate) {
		LocalDate now = DefaultValue.localDateNow();
		
		if (birthDate.isAfter(now) ||
			birthDate.isEqual(now)		)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean check120Year(LocalDate birthDate) {
		LocalDate now = DefaultValue.localDateNow();
		
		Period period = Period.between(now, birthDate);
	    int diff = Math.abs(period.getYears());
	    
	    if (diff > 120)
	    	return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_INVALID_BIRTHDATE;
	}
}
