package br.com.mind5.business.employeeSnapshot.model.checker;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpnapCheckExist extends ModelCheckerTemplateAction<EmpnapInfo, EmpnapInfo> {
	
	public EmpnapCheckExist(ModelCheckerOption option) {
		super(option, EmpnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpnapInfo> buildActionHook(DeciTreeOption<EmpnapInfo> option) {
		ActionStd<EmpnapInfo> select = new StdEmpnapSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_SNAP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_SNAP_NOT_FOUND;
	}
}
