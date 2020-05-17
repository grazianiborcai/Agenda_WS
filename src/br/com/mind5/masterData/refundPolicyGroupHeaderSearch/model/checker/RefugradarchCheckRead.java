package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefugradarchCheckRead extends ModelCheckerTemplateSimpleV2<RefugradarchInfo> {

	public RefugradarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugradarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage  == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_HDR_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
