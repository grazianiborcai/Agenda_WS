package br.com.mind5.business.orderSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdnapCheckRead extends ModelCheckerTemplateSimple<OrdnapInfo> {

	public OrdnapCheckRead(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
