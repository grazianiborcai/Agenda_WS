package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckRead extends ModelCheckerTemplateSimpleV2<MultmoipInfo> {

	public MultmoipCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.idOrderPartner == null )	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
