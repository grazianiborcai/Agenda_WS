package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.TimeAge;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CartemCheckIsTimeAged extends ModelCheckerTemplateSimpleV2<CartemInfo> {

	public CartemCheckIsTimeAged(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (isAged(recordInfo))			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isAged(CartemInfo recordInfo) {
		return new TimeAge().isAged(recordInfo.date, recordInfo.beginTime);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_AGED_DATE;
	}
}
