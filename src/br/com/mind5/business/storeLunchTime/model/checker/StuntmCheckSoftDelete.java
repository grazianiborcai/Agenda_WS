package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoSelect;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmCheckSoftDelete extends ModelCheckerTemplateAction<StuntmInfo, StuntmInfo> {

	public StuntmCheckSoftDelete(ModelCheckerOption option) {
		super(option, StuntmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StuntmInfo> buildActionHook(DeciTreeOption<StuntmInfo> option) {
		ActionStd<StuntmInfo> enforceDel = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceDel.class);
		ActionLazy<StuntmInfo> select = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_FLAGGED_AS_DELETED;	
	}
}
