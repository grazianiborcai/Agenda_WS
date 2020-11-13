package br.com.mind5.business.employeeSnapshot.model.checker;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpnapCheckExist extends ModelCheckerTemplateActionV2<EmpnapInfo, EmpnapInfo> {
	
	public EmpnapCheckExist(ModelCheckerOption option) {
		super(option, EmpnapInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmpnapInfo> buildActionHook(DeciTreeOption<EmpnapInfo> option) {
		ActionStdV2<EmpnapInfo> select = new StdEmpnapDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_SNAP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_SNAP_NOT_FOUND;
	}
}
