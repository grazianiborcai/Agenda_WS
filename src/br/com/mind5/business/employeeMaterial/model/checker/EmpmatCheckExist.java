package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckExist extends ModelCheckerTemplateAction<EmpmatInfo, EmpmatInfo> {	
	
	public EmpmatCheckExist(ModelCheckerOption option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(DeciTreeOption<EmpmatInfo> option) {
		ActionStd<EmpmatInfo> select = new  ActionStdCommom<EmpmatInfo>(option, EmpmatVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_NOT_FOUND;
	}
}
