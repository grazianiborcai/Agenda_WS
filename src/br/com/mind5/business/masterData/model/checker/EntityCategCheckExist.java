package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.action.StdEntityCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntityCategCheckExist extends ModelCheckerTemplateAction_<EntityCategInfo> {
	
	public EntityCategCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EntityCategInfo> buildActionHook(EntityCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EntityCategInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EntityCategInfo> actionSelect = new StdEntityCategSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EntityCategInfo> buildActionOption(EntityCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EntityCategInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ENTITY_CATEG_ALREADY_EXIST)
			return SystemMessage.ENTITY_CATEG_ALREADY_EXIST;
		
		return SystemMessage.ENTITY_CATEG_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ENTITY_CATEG_ALREADY_EXIST;	
			
		return SystemCode.ENTITY_CATEG_NOT_FOUND;
	}
}
