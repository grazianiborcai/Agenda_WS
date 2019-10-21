package br.com.mind5.payment.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckIsFee extends ModelCheckerTemplateSimple_<OrdmoipInfo> {

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
