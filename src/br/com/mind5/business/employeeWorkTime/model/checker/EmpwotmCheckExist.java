package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class EmpwotmCheckExist extends ModelCheckerTemplateActionV2<EmpwotmInfo, EmpwotmInfo> {
	
	public EmpwotmCheckExist(ModelCheckerOption option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(DeciTreeOption<EmpwotmInfo> option) {
		ActionStd<EmpwotmInfo> select = new StdEmpwotmSelect(option);
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_ALREADY_EXIST;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_NOT_FOUND;	
	}
}
