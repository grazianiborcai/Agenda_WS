package br.com.mind5.business.employeeWorkTimeRange.model.checker;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.decisionTree.RootStoworgSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpworgCheckExist extends ModelCheckerTemplateAction<EmpworgInfo, EmpworgInfo> {
	
	public EmpworgCheckExist(ModelCheckerOption option) {
		super(option, EmpworgInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpworgInfo> buildActionHook(DeciTreeOption<EmpworgInfo> option) {
		ActionStdV1<EmpworgInfo> select = new RootStoworgSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_RANGE_NOT_FOUND;
	}
}
