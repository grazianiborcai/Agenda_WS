package br.com.mind5.business.employeeSearch.model.checker;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.RootEmparchSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmparchCheckExistUser extends ModelCheckerTemplateAction<EmparchInfo, EmparchInfo> {
	
	public EmparchCheckExistUser(ModelCheckerOption option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmparchInfo> buildActionHook(DeciTreeOption<EmparchInfo> option) {
		ActionStd<EmparchInfo> select = new RootEmparchSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_SEARCH_EMP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_SEARCH_EMP_NOT_FOUND;
	}
}
