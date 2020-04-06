package br.com.mind5.business.customerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CusarchCheckRead extends ModelCheckerTemplateSimpleV2<CusarchInfo> {

	public CusarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;		
		
		
		
		if (recordInfo.codCustomer 	<= 0 	&&
			recordInfo.codUser 		<= 0 	&&
			recordInfo.personData	== null &&
			recordInfo.phoneData	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUSTOMER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
