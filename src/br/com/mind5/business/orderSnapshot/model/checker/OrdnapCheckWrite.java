package br.com.mind5.business.orderSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class OrdnapCheckWrite extends ModelCheckerTemplateSimple_<OrdnapInfo> {

	public OrdnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codOrder 	<= 0 	||
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
