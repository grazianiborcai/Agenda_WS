package br.com.gda.business.orderItemSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class OrdemrapCheckRead extends ModelCheckerTemplateSimple_<OrdemrapInfo> {

	public OrdemrapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdemrapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codSnapshot	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_ITEM_SNAP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_ITEM_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
