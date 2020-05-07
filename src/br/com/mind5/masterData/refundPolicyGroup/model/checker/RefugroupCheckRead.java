package br.com.mind5.masterData.refundPolicyGroup.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefugroupCheckRead extends ModelCheckerTemplateSimpleV2<RefugroupInfo> {

	public RefugroupCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugroupInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codRefundPolicyGroup <= 0 	||
			 recordInfo.codLanguage 		== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_MANDATORY_FIELD_EMPTY;
	}
}
