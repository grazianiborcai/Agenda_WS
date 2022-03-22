package br.com.mind5.business.customerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CusarchCheckRead extends ModelCheckerTemplateSimple<CusarchInfo> {

	public CusarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)	
			
			return super.FAILED;
	
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUSTOMER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
