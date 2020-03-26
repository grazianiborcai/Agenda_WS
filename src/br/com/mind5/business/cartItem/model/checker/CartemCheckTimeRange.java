package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartemCheckTimeRange extends ModelCheckerTemplateSimple<CartemInfo> {
	
	
	public CartemCheckTimeRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.beginTime == null || recordInfo.endTime == null )
			return super.FAILED;			
		
		if (recordInfo.beginTime.equals(recordInfo.endTime))			
			return super.FAILED;	
		
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))			
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.CART_ITEM_BAD_TIME_RANGE;
	}
}
