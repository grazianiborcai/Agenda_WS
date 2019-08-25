package br.com.gda.business.orderSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrdnapCheckRead extends ModelCheckerTemplateSimple<OrdnapInfo> {

	public OrdnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codOrder 	<= 0 	||
			 recordInfo.codSnapshot	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_HEADER_SNAP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_HEADER_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
