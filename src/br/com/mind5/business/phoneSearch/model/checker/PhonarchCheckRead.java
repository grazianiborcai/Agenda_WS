package br.com.mind5.business.phoneSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhonarchCheckRead extends ModelCheckerTemplateSimpleV2<PhonarchInfo> {

	public PhonarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
			
			
		if ( recordInfo.codPhone 		<= 0	&&
			 recordInfo.codCustomer 	<= 0	&&
			 recordInfo.codStore 		<= 0	&& 
			 recordInfo.codUser 		<= 0	&& 
			 recordInfo.codOwnerRef 	<= 0	&&
			 recordInfo.codEmployee 	<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
