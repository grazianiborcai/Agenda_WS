package br.com.mind5.business.cart.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CartCheckAged extends ModelCheckerTemplateSimpleV2<CartInfo> {

	public CartCheckAged(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.cartems == null )
			return super.SUCCESS;
		
		
		if ( recordInfo.cartems.isEmpty() )
			return super.SUCCESS;
		
		
		for ( CartemInfo earchCartem : recordInfo.cartems ) {
			if ( earchCartem.isAged == true )
				return super.FAILED;
		}
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_HEADER_IS_OK;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.CART_HEADER_IS_AGED;
	}	
}
