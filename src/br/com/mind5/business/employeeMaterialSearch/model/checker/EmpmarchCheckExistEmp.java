package br.com.mind5.business.employeeMaterialSearch.model.checker;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.RootEmpmarchSelectEmp;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmarchCheckExistEmp extends ModelCheckerTemplateAction<EmpmarchInfo, EmpmarchInfo> {	
	
	public EmpmarchCheckExistEmp(ModelCheckerOption option) {
		super(option, EmpmarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpmarchInfo> buildActionHook(DeciTreeOption<EmpmarchInfo> option) {
		ActionStd<EmpmarchInfo> select = new RootEmpmarchSelectEmp(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_SEARCH_NOT_FOUND;
	}
}
