package br.com.mind5.business.employeeWorkTimeSearch.model.checker;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.EmpwotarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotarchCheckExist extends ModelCheckerTemplateAction<EmpwotarchInfo, EmpwotarchInfo> {
	
	public EmpwotarchCheckExist(ModelCheckerOption option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotarchInfo> buildActionHook(DeciTreeOption<EmpwotarchInfo> option) {
		ActionStd<EmpwotarchInfo> select = new EmpwotarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_SEARCH_NOT_FOUND;
	}
}
