package br.com.mind5.business.calendarCatalogueData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CalguataCheckRead extends ModelCheckerTemplateSimple<CalguataInfo> {

	public CalguataCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalguataInfo recordInfo, Connection conn, String schemaName) {	
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
		return SystemCode.CAL_CATALOGUE_DATA_MANDATORY_FIELD_EMPTY;
	}
}
