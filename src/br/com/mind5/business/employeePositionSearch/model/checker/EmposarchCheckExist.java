package br.com.mind5.business.employeePositionSearch.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.decisionTree.RootEmposarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposarchCheckExist extends ModelCheckerTemplateAction<EmposarchInfo, EmposarchInfo> {
	
	public EmposarchCheckExist(ModelCheckerOption option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposarchInfo> buildActionHook(DeciTreeOption<EmposarchInfo> option) {
		ActionStd<EmposarchInfo> select = new RootEmposarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_SEARCH_NOT_FOUND;
	}
}
