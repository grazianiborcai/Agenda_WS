package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CusCheckInsertFromOrder extends ModelCheckerTemplateSimple<CusInfo> {

	public CusCheckInsertFromOrder(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner	<= 0	||
			 recordInfo.codOrder	<= 0	||
			 recordInfo.username 	== null ||
			 recordInfo.codLanguage == null 	)
				
			return super.FAILED;
			
			
			return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_MANDATORY_FIELD_EMPTY;
	}
}
