package br.com.mind5.business.cartReserveConflict.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartercoCheckRead extends ModelCheckerTemplateSimple<CartercoInfo> {

	public CartercoCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartercoInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore	<= 0 	|| 
			 recordInfo.codMat		<= 0 	||
			 recordInfo.codEmployee	<= 0 	||
			 recordInfo.beginTime	== null	||
			 recordInfo.endTime		== null	||
			 recordInfo.date		== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_RESERVE_CONFLICT_MANDATORY_FIELD_EMPTY;
	}
}
