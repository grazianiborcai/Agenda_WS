package br.com.mind5.masterData.currencySearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public class CurrarshCheckRead extends ModelCheckerTemplateSimpleV2<CurrarshInfo> {

	public CurrarshCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CurrarshInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCurr 	== null ||
			 recordInfo.codLanguage == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CURRENCY_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
