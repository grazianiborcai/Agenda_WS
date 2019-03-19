package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatoreCheckPrice extends ModelCheckerTemplateSimple<MatoreInfo> {

	public MatoreCheckPrice() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		int countNull = 0;
		
		if (recordInfo.matPrice <= 0)
			countNull++;
		
		if (   recordInfo.matPrice1 <= 0
			|| recordInfo.matPrice2 <= 0
			|| recordInfo.matPrice3 <= 0
			|| recordInfo.matPrice4 <= 0
			|| recordInfo.matPrice5 <= 0
			|| recordInfo.matPrice6 <= 0
			|| recordInfo.matPrice7 <= 0	)			
			countNull++;
		
		
		if (countNull > 1)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
