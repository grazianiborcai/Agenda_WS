package br.com.mind5.masterData.entityCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.action.StdEntitegDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EntitegCheckExist extends ModelCheckerTemplateAction<EntitegInfo, EntitegInfo> {
	
	public EntitegCheckExist(ModelCheckerOption option) {
		super(option, EntitegInfo.class);
	}
	
	
	
	@Override protected ActionStd<EntitegInfo> buildActionHook(DeciTreeOption<EntitegInfo> option) {
		ActionStd<EntitegInfo> select = new StdEntitegDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ENTITY_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ENTITY_CATEG_NOT_FOUND;
	}
}
