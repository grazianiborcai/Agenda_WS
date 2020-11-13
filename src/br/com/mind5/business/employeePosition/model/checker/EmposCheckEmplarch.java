package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree.RootEmplarchSelect;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckEmplarch extends ModelCheckerTemplateActionV2<EmposInfo, EmplarchInfo> {
	
	public EmposCheckEmplarch(ModelCheckerOption option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmplarchInfo> buildActionHook(DeciTreeOption<EmplarchInfo> option) {
		ActionStdV2<EmplarchInfo> select = new RootEmplarchSelect(option).toAction();
		return select;
	}	
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_HAS_LDATE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NO_LDATE_FOUND;
	}
}
