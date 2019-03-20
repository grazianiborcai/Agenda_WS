package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatoreCheckPriceService extends ModelCheckerTemplateSimple<MatoreInfo> {

	public MatoreCheckPriceService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if (shouldCheck(recordInfo.codCategory) == false)
			return super.SUCCESS;
		
		
		if (recordInfo.matPrice > 0)
			return super.FAILED;
		
		
		if (   recordInfo.matPrice1 <= 0
			&& recordInfo.matPrice2 <= 0
			&& recordInfo.matPrice3 <= 0
			&& recordInfo.matPrice4 <= 0
			&& recordInfo.matPrice5 <= 0
			&& recordInfo.matPrice6 <= 0
			&& recordInfo.matPrice7 <= 0	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean shouldCheck(int codCategory) {
		if (MatCateg.SERVICE.getCodCategory() == codCategory)
			return true;
		
		return false;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_STORE_PRICE_INCONSISTENCY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_STORE_PRICE_INCONSISTENCY;
	}
}
