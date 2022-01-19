package br.com.mind5.business.pet.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetCheckBirthdate extends ModelCheckerTemplateSimple<PetInfo> {

	public PetCheckBirthdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.petBirthDate == null )			
			return super.SUCCESS;		
		
		
		if ( checkFuture(recordInfo.petBirthDate) == super.FAILED )			
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_INVALID_BIRTHDATE;
	}
}
