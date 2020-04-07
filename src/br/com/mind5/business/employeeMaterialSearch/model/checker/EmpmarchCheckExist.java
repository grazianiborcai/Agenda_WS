package br.com.mind5.business.employeeMaterialSearch.model.checker;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.RootEmpmarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmarchCheckExist extends ModelCheckerTemplateActionV2<EmpmarchInfo, EmpmarchInfo> {	
	
	public EmpmarchCheckExist(ModelCheckerOption option) {
		super(option, EmpmarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpmarchInfo> buildActionHook(DeciTreeOption<EmpmarchInfo> option) {
		ActionStdV1<EmpmarchInfo> select = new RootEmpmarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_SEARCH_NOT_FOUND;
	}
}
