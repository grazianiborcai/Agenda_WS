package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.decisionTree.EmpworgRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmCheckEmpworg extends ModelCheckerTemplateAction<EmplutmInfo, EmpworgInfo> {

	public EmplutmCheckEmpworg(ModelCheckerOption option) {
		super(option, EmpworgInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpworgInfo> buildActionHook(DeciTreeOption<EmpworgInfo> option) {
		ActionStd<EmpworgInfo> select = new EmpworgRootSelect(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LTIME_RANGE_OK;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_RANGE_CONFLICT;	
	}
}
