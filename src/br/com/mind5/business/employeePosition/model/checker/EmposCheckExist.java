package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.EmposVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckExist extends ModelCheckerTemplateAction<EmposInfo, EmposInfo> {
	
	public EmposCheckExist(ModelCheckerOption option) {
		super(option, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> buildActionHook(DeciTreeOption<EmposInfo> option) {
		ActionStd<EmposInfo> select = new ActionStdCommom<EmposInfo>(option, EmposVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NOT_FOUND;
	}
}
