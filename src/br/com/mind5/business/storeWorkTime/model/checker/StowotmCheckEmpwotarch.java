package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.RootEmpwotarchSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckEmpwotarch extends ModelCheckerTemplateActionV2<StowotmInfo, EmpwotarchInfo> {
	
	public StowotmCheckEmpwotarch(ModelCheckerOption option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotarchInfo> buildActionHook(DeciTreeOption<EmpwotarchInfo> option) {
		ActionStd<EmpwotarchInfo> select = new RootEmpwotarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_HAS_EMPLOYEE;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_EMPLOYEE_NOT_FOUND;
	}
}
