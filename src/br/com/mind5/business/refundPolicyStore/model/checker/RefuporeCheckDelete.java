package br.com.mind5.business.refundPolicyStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class RefuporeCheckDelete extends ModelCheckerTemplateSimple<RefuporeInfo> {

	public RefuporeCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefuporeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codStore 		<= 0 	||
			 recordInfo.codLanguage 	== null ||
			 recordInfo.username 		== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_MANDATORY_FIELD_EMPTY;
	}
}
