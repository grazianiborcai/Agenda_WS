package br.com.mind5.business.orderItemList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdemistCheckRead extends ModelCheckerTemplateSimple<OrdemistInfo> {

	public OrdemistCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdemistInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codOrder		<= 0 	||
			 recordInfo.codOrderItem	<= 0 	||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_LIST_MANDATORY_FIELD_EMPTY;
	}
}
