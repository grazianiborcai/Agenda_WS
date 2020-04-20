package br.com.mind5.masterData.currency.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public class CurrencyCheckRead extends ModelCheckerTemplateSimpleV2<CurrencyInfo> {

	public CurrencyCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CurrencyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCurr 	== null ||
			 recordInfo.codLanguage == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CURRENCY_MANDATORY_FIELD_EMPTY;
	}
}
