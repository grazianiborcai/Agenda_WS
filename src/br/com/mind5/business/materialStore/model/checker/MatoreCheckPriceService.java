package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatoreCheckPriceService extends ModelCheckerTemplateSimple_<MatoreInfo> {

	public MatoreCheckPriceService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if (shouldCheck(recordInfo.codMatCateg) == false)
			return super.SUCCESS;
		
		
		if (recordInfo.matPrice > 0)
			return super.FAILED;
		
		
		if (   recordInfo.matPrice1 <= 0
			|| recordInfo.matPrice2 <= 0
			|| recordInfo.matPrice3 <= 0
			|| recordInfo.matPrice4 <= 0
			|| recordInfo.matPrice5 <= 0
			|| recordInfo.matPrice6 <= 0
			|| recordInfo.matPrice7 <= 0	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean shouldCheck(int codCategory) {
		if (MatCateg.SERVICE.getCodMatCateg() == codCategory)
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
