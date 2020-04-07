package br.com.mind5.business.employeePositionSearch.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.decisionTree.RootEmposarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposarchCheckExist extends ModelCheckerTemplateActionV2<EmposarchInfo, EmposarchInfo> {
	
	public EmposarchCheckExist(ModelCheckerOption option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmposarchInfo> buildActionHook(DeciTreeOption<EmposarchInfo> option) {
		ActionStdV1<EmposarchInfo> select = new RootEmposarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_SEARCH_NOT_FOUND;
	}
}
