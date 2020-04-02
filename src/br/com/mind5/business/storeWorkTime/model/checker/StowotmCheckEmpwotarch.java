package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.RootEmpwotarchSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckEmpwotarch extends ModelCheckerTemplateAction<StowotmInfo, EmpwotarchInfo> {
	
	public StowotmCheckEmpwotarch(ModelCheckerOption option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpwotarchInfo> buildActionHook(DeciTreeOption<EmpwotarchInfo> option) {
		ActionStdV1<EmpwotarchInfo> select = new RootEmpwotarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_HAS_EMPLOYEE;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_EMPLOYEE_NOT_FOUND;
	}
}
