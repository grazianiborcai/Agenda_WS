package br.com.mind5.business.employeeLeaveDateSearch.model.checker;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree.RootEmplarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplarchCheckExist extends ModelCheckerTemplateAction<EmplarchInfo, EmplarchInfo> {
	
	public EmplarchCheckExist(ModelCheckerOption option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplarchInfo> buildActionHook(DeciTreeOption<EmplarchInfo> option) {
		ActionStd<EmplarchInfo> select = new RootEmplarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_SEARCH_NOT_FOUND;
	}
}
