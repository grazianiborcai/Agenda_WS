package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefugritarchCheckRead extends ModelCheckerTemplateSimpleV2<RefugritarchInfo> {

	public RefugritarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugritarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codRefundPolicyGroup 	<= 0 	||
			 recordInfo.codLanguage 			== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
