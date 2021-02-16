package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;
import java.time.LocalTime;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartemCheckTimeRange extends ModelCheckerTemplateSimple<CartemInfo> {
	
	
	public CartemCheckTimeRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (isNull(recordInfo.beginTime, recordInfo.endTime) == true)
			return super.FAILED;
		
		if (isInvalidRange(recordInfo.beginTime, recordInfo.endTime) == true)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isNull(LocalTime beginTime, LocalTime endTime) {
		if (beginTime == null || endTime == null )
			return true;
		
		return false;
	}
	
	
	
	private boolean isInvalidRange(LocalTime beginTime, LocalTime endTime) {
		if (beginTime.equals(endTime))			
			return true;	
		
		if (beginTime.isAfter(endTime))			
			return true;
		
		return false;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.CART_ITEM_BAD_TIME_RANGE;
	}
}
