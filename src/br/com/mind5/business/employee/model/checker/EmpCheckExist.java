package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.StdEmpDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpCheckExist extends ModelCheckerTemplateActionV2<EmpInfo, EmpInfo> {
	
	public EmpCheckExist(ModelCheckerOption option) {
		super(option, EmpInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpInfo> buildActionHook(DeciTreeOption<EmpInfo> option) {
		ActionStdV1<EmpInfo> select = new StdEmpDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_NOT_FOUND;
	}
}
