package br.com.mind5.business.employeeLeaveDateSearch.model.checker;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.action.StdEmplarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplarchCheckExist extends ModelCheckerTemplateActionV2<EmplarchInfo, EmplarchInfo> {
	
	public EmplarchCheckExist(ModelCheckerOption option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplarchInfo> buildActionHook(DeciTreeOption<EmplarchInfo> option) {
		ActionStd<EmplarchInfo> select = new StdEmplarchSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
