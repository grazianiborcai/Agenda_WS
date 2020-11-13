package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckEmpwoco extends ModelCheckerTemplateActionV2<EmpwotmInfo, EmpwocoInfo> {
	
	public EmpwotmCheckEmpwoco(ModelCheckerOption option) {
		super(option, EmpwocoInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<EmpwocoInfo> buildActionHook(DeciTreeOption<EmpwocoInfo> option) {
		ActionStdV2<EmpwocoInfo> select = new RootEmpwocoSelect(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_CONFLICT_FOUND;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_CONFLICT_FREE;	
	}
}
