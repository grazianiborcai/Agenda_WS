package br.com.mind5.business.calendarCatalogue.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CalgueCheckRead extends ModelCheckerTemplateSimpleV2<CalgueInfo> {

	public CalgueCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalgueInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore 	<= 0 	||
			 recordInfo.codMat 		<= 0 	||
			 recordInfo.year 		<= 0 	||
			 recordInfo.month 		<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_CATALOGUE_MANDATORY_FIELD_EMPTY;
	}
}