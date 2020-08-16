package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatoreCheckPriceService extends ModelCheckerTemplateSimpleV2<MatoreInfo> {

	public MatoreCheckPriceService(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		
		if (recordInfo.matPrice > 0)
			return super.FAILED;
		
		
		if ( recordInfo.matPrice1 <= 0	||
			 recordInfo.matPrice2 <= 0	||
			 recordInfo.matPrice3 <= 0	||
			 recordInfo.matPrice4 <= 0	||
			 recordInfo.matPrice5 <= 0	||
			 recordInfo.matPrice6 <= 0	||
			 recordInfo.matPrice7 <= 0		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_PRICE_INCONSISTENCY;
	}	
}
