package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiDaoSelect;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatCheckSoftDelete extends ModelCheckerTemplateAction<EmpmatInfo, EmpmatInfo> {	
	
	public EmpmatCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> buildActionHook(DeciTreeOption<EmpmatInfo> option) {		
		ActionStd<EmpmatInfo> enforceDel = new ActionStdCommom<EmpmatInfo>(option, EmpmatVisiEnforceDel.class);
		ActionLazy<EmpmatInfo> select = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_MAT_FLAGGED_AS_DELETED;
	}	
}
