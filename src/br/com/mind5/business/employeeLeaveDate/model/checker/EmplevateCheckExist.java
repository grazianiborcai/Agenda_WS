package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplevateCheckExist extends ModelCheckerTemplateActionV2<EmplevateInfo, EmplevateInfo> {
	
	public EmplevateCheckExist(ModelCheckerOption option) {
		super(option, EmplevateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> buildActionHook(DeciTreeOption<EmplevateInfo> option) {
		ActionStd<EmplevateInfo> select = new StdEmplevateSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
