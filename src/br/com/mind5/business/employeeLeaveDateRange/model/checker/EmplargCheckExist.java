package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.decisionTree.RootEmplargSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplargCheckExist extends ModelCheckerTemplateActionV2<EmplargInfo, EmplargInfo> {
	
	public EmplargCheckExist(ModelCheckerOption option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmplargInfo> buildActionHook(DeciTreeOption<EmplargInfo> option) {
		ActionStdV1<EmplargInfo> select = new RootEmplargSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_RANGE_NOT_FOUND;
	}
}
