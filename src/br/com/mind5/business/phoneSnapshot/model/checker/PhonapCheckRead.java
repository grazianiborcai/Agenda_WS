package br.com.mind5.business.phoneSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhonapCheckRead extends ModelCheckerTemplateSimpleV2<PhonapInfo> {

	public PhonapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 ||
			 recordInfo.codSnapshot <= 0 ||
			 recordInfo.codLanguage	== null )		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
