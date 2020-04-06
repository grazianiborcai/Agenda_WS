package br.com.mind5.business.materialStockSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatocarchCheckRead extends ModelCheckerTemplateSimpleV2<MatocarchInfo> {

	public MatocarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatocarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		
		if (recordInfo.codStore 	<= 0 	&& 
		    recordInfo.codMat 		<= 0 		) 
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STOCK_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
