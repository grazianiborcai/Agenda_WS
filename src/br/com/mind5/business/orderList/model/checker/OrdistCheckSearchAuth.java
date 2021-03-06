package br.com.mind5.business.orderList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdistCheckSearchAuth extends ModelCheckerTemplateSimple<OrdistInfo> {

	public OrdistCheckSearchAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdistInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_LIST_MANDATORY_FIELD_EMPTY;
	}
}
