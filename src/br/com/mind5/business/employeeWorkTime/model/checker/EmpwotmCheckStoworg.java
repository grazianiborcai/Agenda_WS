package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.decisionTree.StoworgRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckStoworg extends ModelCheckerTemplateAction<EmpwotmInfo, StoworgInfo> {

	public EmpwotmCheckStoworg(ModelCheckerOption option) {
		super(option, StoworgInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoworgInfo> buildActionHook(DeciTreeOption<StoworgInfo> option) {
		ActionStd<StoworgInfo> select = new StoworgRootSelect(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_RANGE_OK;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_RANGE_CONFLICT;	
	}
}
