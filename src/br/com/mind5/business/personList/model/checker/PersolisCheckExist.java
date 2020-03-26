package br.com.mind5.business.personList.model.checker;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersolisCheckExist extends ModelCheckerTemplateAction<PersolisInfo, PersolisInfo> {
	
	public PersolisCheckExist(ModelCheckerOption option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected ActionStd<PersolisInfo> buildActionHook(DeciTreeOption<PersolisInfo> option) {
		ActionStd<PersolisInfo> select = new RootPersolisSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_LIST_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_LIST_NOT_FOUND;
	}
}
