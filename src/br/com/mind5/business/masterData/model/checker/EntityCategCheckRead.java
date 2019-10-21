package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EntityCategCheckRead extends ModelCheckerTemplateSimple_<EntityCategInfo> {
	
	public EntityCategCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EntityCategInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ENTITY_CATEG_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ENTITY_CATEG_MANDATORY_FIELD_EMPTY;
	}
}
