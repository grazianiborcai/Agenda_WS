package br.com.mind5.discount.discountStoreSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisorarchCheckRead extends ModelCheckerTemplateSimple<DisorarchInfo> {

	public DisorarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisorarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
