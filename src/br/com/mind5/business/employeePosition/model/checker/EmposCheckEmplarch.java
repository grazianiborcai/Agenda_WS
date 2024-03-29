package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree.EmplarchRootSelect;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckEmplarch extends ModelCheckerTemplateAction<EmposInfo, EmplarchInfo> {
	
	public EmposCheckEmplarch(ModelCheckerOption option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplarchInfo> buildActionHook(DeciTreeOption<EmplarchInfo> option) {
		ActionStd<EmplarchInfo> select = new EmplarchRootSelect(option).toAction();
		return select;
	}	
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_HAS_LDATE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NO_LDATE_FOUND;
	}
}
