package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiDaoSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateCheckSoftDelete extends ModelCheckerTemplateAction<EmplateInfo, EmplateInfo> {	
	
	public EmplateCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> buildActionHook(DeciTreeOption<EmplateInfo> option) {
		ActionStd<EmplateInfo> enforceDel = new ActionStdCommom<EmplateInfo>(option, EmplateVisiEnforceDel.class);
		ActionLazy<EmplateInfo> select = new ActionLazyCommom<EmplateInfo>(option, EmplateVisiDaoSelect.class);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_FLAGGED_AS_DELETED;
	}	
}
