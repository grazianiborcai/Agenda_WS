package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPay extends ModelCheckerTemplateSimpleV2<MultmoipInfo> {

	public MultmoipCheckPay(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.codOwner 		<= 0	||		
			 recordInfo.codPayOrder 	<= 0	||	
			 recordInfo.txtFeeCateg 	== null	||
			 recordInfo.codLanguage 	== null	||
			 recordInfo.username 		== null	||
		     recordInfo.payordems		== null	||
		     recordInfo.cusparData		== null	||
		     recordInfo.sysparData		== null		)	
			
			return super.FAILED;
		
		
		if (recordInfo.payordems.isEmpty())
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
