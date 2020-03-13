package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatUnit;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatCheckServicePriceUnitMin extends ModelCheckerTemplateSimpleV2<MatInfo> {

	public MatCheckServicePriceUnitMin(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUnit == null)
			return super.SUCCESS;
		
		
		if (MatUnit.MINUTE.getCodUnit().equals(recordInfo.codUnit) == false)					
			return super.SUCCESS;	
		
		
		if (recordInfo.priceUnit >= 15)			
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_PRICE_UNIT_LOWER_THAN_MIN;
	}
}
