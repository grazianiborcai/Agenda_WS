package br.com.mind5.business.cartItemSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartemarchCheckRead extends ModelCheckerTemplateSimple<CartemarchInfo> {

	public CartemarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codUser 	<= 0 	&&
			 recordInfo.codStore 	<= 0 	&&
			 recordInfo.codMat 		<= 0 	&&
			 recordInfo.codEmployee <= 0 	&&
			 recordInfo.date		== null	&&
			 recordInfo.beginTime	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
