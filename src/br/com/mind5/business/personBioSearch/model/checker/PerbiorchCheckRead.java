package br.com.mind5.business.personBioSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerbiorchCheckRead extends ModelCheckerTemplateSimple<PerbiorchInfo> {

	public PerbiorchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerbiorchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.username 	== null ||
			 recordInfo.codPerson 	<= 0		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
