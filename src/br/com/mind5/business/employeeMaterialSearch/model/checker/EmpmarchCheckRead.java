package br.com.mind5.business.employeeMaterialSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpmarchCheckRead extends ModelCheckerTemplateSimpleV2<EmpmarchInfo> {

	public EmpmarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpmarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner   	<= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username  	== null	)		
			
			return super.FAILED;
		
		
		if ( recordInfo.codMat      <= 0	||
			 recordInfo.codEmployee <= 0	)		
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
