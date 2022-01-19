package br.com.mind5.business.petSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerarchCheckReadEmailPerson extends ModelCheckerTemplateSimple<PetarchInfo> {

	public PerarchCheckReadEmailPerson(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  		<= 0 	||
			 recordInfo.codPet  		<= 0 	||
			 recordInfo.codEntityCateg  == null ||
			 recordInfo.email  			== null ||
			 recordInfo.username		== null	||
			 recordInfo.codLanguage		== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
