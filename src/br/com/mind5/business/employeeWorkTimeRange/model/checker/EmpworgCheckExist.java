package br.com.mind5.business.employeeWorkTimeRange.model.checker;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.decisionTree.RootStoworgSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpworgCheckExist extends ModelCheckerTemplateActionV2<EmpworgInfo, EmpworgInfo> {
	
	public EmpworgCheckExist(ModelCheckerOption option) {
		super(option, EmpworgInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmpworgInfo> buildActionHook(DeciTreeOption<EmpworgInfo> option) {
		ActionStdV2<EmpworgInfo> select = new RootStoworgSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_RANGE_NOT_FOUND;
	}
}
