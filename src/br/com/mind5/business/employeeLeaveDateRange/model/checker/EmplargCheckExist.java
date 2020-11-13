package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.decisionTree.RootEmplargSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplargCheckExist extends ModelCheckerTemplateAction<EmplargInfo, EmplargInfo> {
	
	public EmplargCheckExist(ModelCheckerOption option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplargInfo> buildActionHook(DeciTreeOption<EmplargInfo> option) {
		ActionStd<EmplargInfo> select = new RootEmplargSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_RANGE_NOT_FOUND;
	}
}
