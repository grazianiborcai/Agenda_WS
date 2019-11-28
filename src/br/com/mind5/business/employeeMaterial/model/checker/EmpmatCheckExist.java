package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.StdEmpmatSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckExist extends ModelCheckerTemplateActionV2<EmpmatInfo, EmpmatInfo> {	
	
	public EmpmatCheckExist(ModelCheckerOption option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(DeciTreeOption<EmpmatInfo> option) {
		ActionStd<EmpmatInfo> select = new StdEmpmatSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_NOT_FOUND;
	}
}
