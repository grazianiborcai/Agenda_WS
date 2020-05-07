package br.com.mind5.masterData.refundPolicyGroupHeader.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefugraderCheckRead extends ModelCheckerTemplateSimpleV2<RefugraderInfo> {

	public RefugraderCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugraderInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codRefundPolicyGroup <= 0 		||
			 recordInfo.codLanguage 		 == null 		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_HDR_MANDATORY_FIELD_EMPTY;
	}
}
