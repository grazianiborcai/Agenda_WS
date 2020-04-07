package br.com.mind5.business.employeeWorkTimeOutlier.model.checker;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwoutCheckExist extends ModelCheckerTemplateActionV2<EmpwoutInfo, EmpwoutInfo> {	

	public EmpwoutCheckExist(ModelCheckerOption option) {
		super(option, EmpwoutInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpwoutInfo> buildActionHook(DeciTreeOption<EmpwoutInfo> option) {
		ActionStdV1<EmpwoutInfo> select = new RootEmpwoutSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WT_OUT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WT_OUT_NOT_FOUND;
	}
}
