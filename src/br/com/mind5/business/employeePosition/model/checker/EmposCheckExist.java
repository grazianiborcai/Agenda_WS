package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.StdEmposDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckExist extends ModelCheckerTemplateActionV2<EmposInfo, EmposInfo> {
	
	public EmposCheckExist(ModelCheckerOption option) {
		super(option, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmposInfo> buildActionHook(DeciTreeOption<EmposInfo> option) {
		ActionStdV2<EmposInfo> select = new StdEmposDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NOT_FOUND;
	}
}
