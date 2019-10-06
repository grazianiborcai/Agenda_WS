package br.com.gda.business.employeeWorkTimeOutlier.model.checker;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwoutCheckExist extends ModelCheckerTemplateActionV2<EmpwoutInfo, EmpwoutInfo> {	

	public EmpwoutCheckExist(ModelCheckerOption option) {
		super(option, EmpwoutInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwoutInfo> buildActionHook(DeciTreeOption<EmpwoutInfo> option) {
		ActionStd<EmpwoutInfo> select = new RootEmpwoutSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WT_OUT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WT_OUT_NOT_FOUND;
	}
}
