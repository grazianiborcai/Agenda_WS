package br.com.mind5.masterData.businessArea.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class BusareaCheckRead extends ModelCheckerTemplateSimpleV2<BusareaInfo> {
	
	public BusareaCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BusareaInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codBusiness <= 0 	||
			 recordInfo.codLanguage == null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BUSINESS_MANDATORY_FIELD_EMPTY;
	}
}
