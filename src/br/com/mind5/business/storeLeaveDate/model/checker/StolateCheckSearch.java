package br.com.mind5.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StolateCheckSearch extends ModelCheckerTemplateSimple<StolateInfo> {

	public StolateCheckSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolateInfo recordInfo, Connection conn, String schemaName) {	
		if (	recordInfo.codOwner 		<= 0 
			 || recordInfo.codStore  		<= 0 
			 || recordInfo.username			== null
			 || recordInfo.codLanguage		== null	)		
			
		return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_LDATE_MANDATORY_FIELD_EMPTY;
	}
}
