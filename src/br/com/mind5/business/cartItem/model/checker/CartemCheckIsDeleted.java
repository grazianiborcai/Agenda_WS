package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartemCheckIsDeleted extends ModelCheckerTemplateSimple<CartemInfo> {

	public CartemCheckIsDeleted(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.isDeleted)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_FLAG_DELETE_TRUE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_FLAG_DELETE_FALSE;
	}
}
