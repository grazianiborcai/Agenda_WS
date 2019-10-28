package br.com.mind5.payment.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckPlace extends ModelCheckerTemplateSimpleV2<OrdmoipInfo> {

	public OrdmoipCheckPlace(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.payordemData == null )	
			return super.FAILED;
		
		if ( recordInfo.payordemData.codOwner 	 		<= 0 	|| 
			 recordInfo.payordemData.codPayPartner 		<= 0 	|| 
			 recordInfo.payordemData.codPayOrder 		<= 0 	|| 
			 recordInfo.payordemData.codPayOrderItem 	<= 0 	|| 
			 recordInfo.payordemData.quantity 	 		<= 0 	|| 
			 recordInfo.payordemData.price 	  	 		<= 0 	||
			 recordInfo.payordemData.itemReceiver 		== null ||
			 recordInfo.payordemData.codLanguage 		== null ||
			 recordInfo.payordemData.username 			== null		)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
