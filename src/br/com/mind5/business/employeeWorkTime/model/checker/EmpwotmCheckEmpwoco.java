package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.EmpwocoRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckEmpwoco extends ModelCheckerTemplateAction<EmpwotmInfo, EmpwocoInfo> {
	
	public EmpwotmCheckEmpwoco(ModelCheckerOption option) {
		super(option, EmpwocoInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwocoInfo> buildActionHook(DeciTreeOption<EmpwocoInfo> option) {
		ActionStd<EmpwocoInfo> select = new EmpwocoRootSelect(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_CONFLICT_FOUND;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_CONFLICT_FREE;	
	}
}
