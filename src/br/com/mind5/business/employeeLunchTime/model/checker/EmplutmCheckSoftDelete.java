package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoSelect;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmCheckSoftDelete extends ModelCheckerTemplateAction<EmplutmInfo, EmplutmInfo> {
	
	public EmplutmCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmplutmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplutmInfo> buildActionHook(DeciTreeOption<EmplutmInfo> option) {
		ActionStd<EmplutmInfo> enforceDel = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiEnforceDel.class);
		ActionLazy<EmplutmInfo> select = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiDaoSelect.class);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LTIME_FLAGGED_AS_DELETED;	
	}
}
