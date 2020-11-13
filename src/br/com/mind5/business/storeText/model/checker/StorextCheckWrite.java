package br.com.mind5.business.storeText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextCheckWrite extends ModelCheckerTemplateSimple<StorextInfo> {

	public StorextCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore	<= 0	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.description	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_MANDATORY_FIELD_EMPTY;
	}
}
