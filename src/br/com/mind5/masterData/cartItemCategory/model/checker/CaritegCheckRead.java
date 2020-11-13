package br.com.mind5.masterData.cartItemCategory.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CaritegCheckRead extends ModelCheckerTemplateSimple<CaritegInfo> {
	
	public CaritegCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CaritegInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codItemCateg == DefaultValue.character()	||
			 recordInfo.codLanguage  == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_CATEG_MANDATORY_FIELD_EMPTY;
	}
}
