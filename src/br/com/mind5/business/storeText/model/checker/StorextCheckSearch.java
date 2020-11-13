package br.com.mind5.business.storeText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextCheckSearch extends ModelCheckerTemplateSimple<StorextInfo> {

	public StorextCheckSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_MANDATORY_FIELD_EMPTY;
	}
}
