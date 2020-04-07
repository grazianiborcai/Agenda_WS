package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.action.StdEntityCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntityCategCheckExist extends ModelCheckerTemplateActionV2<EntityCategInfo, EntityCategInfo> {
	
	public EntityCategCheckExist(ModelCheckerOption option) {
		super(option, EntityCategInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EntityCategInfo> buildActionHook(DeciTreeOption<EntityCategInfo> option) {
		ActionStdV1<EntityCategInfo> select = new StdEntityCategSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ENTITY_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ENTITY_CATEG_NOT_FOUND;
	}
}
