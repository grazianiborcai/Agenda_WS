package br.com.mind5.masterData.entityCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.action.StdEntitegDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntitegCheckExist extends ModelCheckerTemplateActionV2<EntitegInfo, EntitegInfo> {
	
	public EntitegCheckExist(ModelCheckerOption option) {
		super(option, EntitegInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EntitegInfo> buildActionHook(DeciTreeOption<EntitegInfo> option) {
		ActionStdV2<EntitegInfo> select = new StdEntitegDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ENTITY_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ENTITY_CATEG_NOT_FOUND;
	}
}
