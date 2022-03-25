package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiDaoSelect;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckSoftDelete extends ModelCheckerTemplateAction<EmpwotmInfo, EmpwotmInfo> {
	
	public EmpwotmCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> buildActionHook(DeciTreeOption<EmpwotmInfo> option) {
		ActionStd<EmpwotmInfo> enforceDel = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiEnforceDel.class);
		ActionLazy<EmpwotmInfo> select = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiDaoSelect.class);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_FLAGGED_AS_DELETED;	
	}
}
