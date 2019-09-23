package br.com.gda.business.phoneSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhonarchCheckRead extends ModelCheckerTemplateSimpleV2<PhonarchInfo> {

	public PhonarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhonarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username	== null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
