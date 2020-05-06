package br.com.mind5.masterData.refundPolicy.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefupoCheckRead extends ModelCheckerTemplateSimpleV2<RefupoInfo> {

	public RefupoCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefupoInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codRefundPolicy == null ||
			 recordInfo.codLanguage 	== null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_POLICY_MANDATORY_FIELD_EMPTY;
	}
}
