package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatUnit;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatCheckServicePriceUnitMax extends ModelCheckerTemplateSimpleV2<MatInfo> {

	public MatCheckServicePriceUnitMax(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUnit == null)
			return super.SUCCESS;
		
		
		if (MatUnit.MINUTE.getCodUnit().equals(recordInfo.codUnit) == false)					
			return super.SUCCESS;	
		
		
		if (checkHour(recordInfo) 	== false ||
			checkMinute(recordInfo) == false	)			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkHour(MatInfo recordInfo) {
		if (MatUnit.HOUR.getCodUnit().equals(recordInfo.codUnit) == false)					
			return super.SUCCESS;
		
		if (recordInfo.priceUnit > 4)			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkMinute(MatInfo recordInfo) {
		if (MatUnit.MINUTE.getCodUnit().equals(recordInfo.codUnit) == false)					
			return super.SUCCESS;
		
		if (recordInfo.priceUnit > 4 * 60 )			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_PRICE_UNIT_GREATER_THAN_MAX;
	}
}
