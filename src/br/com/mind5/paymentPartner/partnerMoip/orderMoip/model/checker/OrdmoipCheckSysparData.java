package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckSysparData extends ModelCheckerTemplateSimple<OrdmoipInfo> {

	public OrdmoipCheckSysparData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.sysparData == null )	
			return super.FAILED;
		
		if ( recordInfo.sysparData.idPayPartnerSystem == null )	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
