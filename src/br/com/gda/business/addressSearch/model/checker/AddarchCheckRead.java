package br.com.gda.business.addressSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.addressSearch.info.AddarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class AddarchCheckRead extends ModelCheckerTemplateSimpleV2<AddarchInfo> {

	public AddarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		if ( recordInfo.codAddress 		<= 0	&&
			 recordInfo.codCustomer 	<= 0	&&
			 recordInfo.codStore 		<= 0	&& 
			 recordInfo.codUser 		<= 0	&& 
			 recordInfo.codOwnerRef 	<= 0	&&
			 recordInfo.codEmployee 	<= 0		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
