package br.com.mind5.business.employeeLunchTimeSearch.model.checker;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.decisionTree.EmplutmarchRootSelectEmpos;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmarchCheckExistEmpos extends ModelCheckerTemplateAction<EmplutmarchInfo, EmplutmarchInfo> {
	
	public EmplutmarchCheckExistEmpos(ModelCheckerOption option) {
		super(option, EmplutmarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplutmarchInfo> buildActionHook(DeciTreeOption<EmplutmarchInfo> option) {
		ActionStd<EmplutmarchInfo> select = new EmplutmarchRootSelectEmpos(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_SEARCH_NOT_FOUND;
	}
}
