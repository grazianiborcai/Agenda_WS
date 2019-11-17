package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateCheckExist extends ModelCheckerTemplateActionV2<EmplateInfo, EmplateInfo> {
	
	public EmplateCheckExist(ModelCheckerOption option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> buildActionHook(DeciTreeOption<EmplateInfo> option) {
		ActionStd<EmplateInfo> select = new StdEmplateSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
