package br.com.mind5.business.personBio.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PerbioCheckFlagDel extends ModelCheckerTemplateSimple<PerbioInfo> {

	public PerbioCheckFlagDel(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerbioInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isDeleted )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_MANDATORY_FIELD_EMPTY;
	}
}
