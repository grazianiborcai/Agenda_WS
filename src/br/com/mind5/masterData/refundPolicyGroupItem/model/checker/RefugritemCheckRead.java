package br.com.mind5.masterData.refundPolicyGroupItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefugritemCheckRead extends ModelCheckerTemplateSimpleV2<RefugritemInfo> {

	public RefugritemCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugritemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codRefundPolicyGroup 	<= 0 	||
			 recordInfo.codRefundPolicy 		<= 0 	||
			 recordInfo.codLanguage 			== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_ITM_MANDATORY_FIELD_EMPTY;
	}
}
