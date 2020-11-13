package br.com.mind5.business.phoneSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PhonapCheckWrite extends ModelCheckerTemplateSimple<PhonapInfo> {

	public PhonapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codPhone 	<= 0 	||
			 recordInfo.codLanguage	== null ||
			 recordInfo.username	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
