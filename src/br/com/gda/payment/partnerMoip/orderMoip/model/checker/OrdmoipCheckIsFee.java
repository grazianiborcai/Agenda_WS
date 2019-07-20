package br.com.gda.payment.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckIsFee extends ModelCheckerTemplateSimple<OrdmoipInfo> {

	public OrdmoipCheckIsFee(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.payordemData.codFeeCateg == DefaultValue.character())			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.ORDER_MOIP_ITEM_IS_FEE)
			return SystemMessage.ORDER_MOIP_ITEM_IS_FEE;
		
		return SystemMessage.ORDER_MOIP_ITEM_IS_NOT_FEE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ORDER_MOIP_ITEM_IS_FEE;	
		
		return SystemCode.ORDER_MOIP_ITEM_IS_NOT_FEE;
	}
}
