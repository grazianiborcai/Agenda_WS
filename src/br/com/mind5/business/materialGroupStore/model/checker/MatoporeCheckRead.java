package br.com.mind5.business.materialGroupStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoporeCheckRead extends ModelCheckerTemplateSimple<MatoporeInfo> {

	public MatoporeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoporeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codStore    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GRP_STORE_MANDATORY_FIELD_EMPTY;
	}
}
