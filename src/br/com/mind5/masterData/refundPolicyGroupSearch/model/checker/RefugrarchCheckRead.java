package br.com.mind5.masterData.refundPolicyGroupSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class RefugrarchCheckRead extends ModelCheckerTemplateSimple<RefugrarchInfo> {

	public RefugrarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefugrarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage  == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_GR_HDR_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
