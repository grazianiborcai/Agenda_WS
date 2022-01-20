package br.com.mind5.business.petSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetarchCheckRead extends ModelCheckerTemplateSimple<PetarchInfo> {

	public PetarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
			return super.FAILED;		
		
		
		if ( recordInfo.codPet 		<= 0 	&&
			 recordInfo.codUser 	<= 0	&&
			 recordInfo.codStore 	<= 0	&&
			 recordInfo.codCustomer <= 0		)			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
