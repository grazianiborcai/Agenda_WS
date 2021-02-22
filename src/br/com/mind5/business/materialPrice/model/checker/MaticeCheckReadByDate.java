package br.com.mind5.business.materialPrice.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MaticeCheckReadByDate extends ModelCheckerTemplateSimple<MaticeInfo> {

	public MaticeCheckReadByDate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MaticeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.codMat		<= 0	||
			 recordInfo.date		== null ||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
		
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_PRICE_MANDATORY_FIELD_EMPTY;
	}
}
