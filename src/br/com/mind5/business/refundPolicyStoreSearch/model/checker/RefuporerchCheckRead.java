package br.com.mind5.business.refundPolicyStoreSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefuporerchCheckRead extends ModelCheckerTemplateSimpleV2<RefuporerchInfo> {

	public RefuporerchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefuporerchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codStore 		<= 0 	||
			 recordInfo.codRefundPolicy <= 0 	||
			 recordInfo.codLanguage 	== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
