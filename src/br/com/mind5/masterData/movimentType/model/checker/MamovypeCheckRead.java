package br.com.mind5.masterData.movimentType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MamovypeCheckRead extends ModelCheckerTemplateSimple<MamovypeInfo> {
	
	public MamovypeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MamovypeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_TYPE_MANDATORY_FIELD_EMPTY;
	}
}
