package br.com.mind5.business.materialStoreSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatorapCheckRead extends ModelCheckerTemplateSimple<MatorapInfo> {

	public MatorapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatorapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0
			|| recordInfo.codSnapshot <= 0
			|| recordInfo.codLanguage == null
			|| recordInfo.username	  == null	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
