package br.com.mind5.business.orderStatusChange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdugeCheckPartner extends ModelCheckerTemplateSimple<OrdugeInfo> {

	public OrdugeCheckPartner(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdugeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayOrder 	    <= 0    ||
			 recordInfo.statusOrderPartner 	== null ||
			 recordInfo.username			== null	||
			 recordInfo.codLanguage			== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_STATUS_CHANGE_MANDATORY_FIELD_EMPTY;
	}
}
