package br.com.mind5.business.materialMovementSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatmarchCheckRead extends ModelCheckerTemplateSimple<MatmarchInfo> {

	public MatmarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatmarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		if (recordInfo.codMatmov 	<= 0 	&& 
			recordInfo.codMat 		<= 0 	&&
			recordInfo.codStore		<= 0		)	
			
			return super.FAILED;
		
		
		if (recordInfo.codMatmov 			<= 0 	&& 
			recordInfo.postingYearMonth 	<= 0 	&&
			recordInfo.postingYear			<= 0		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
