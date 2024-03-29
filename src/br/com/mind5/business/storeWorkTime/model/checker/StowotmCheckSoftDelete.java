package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiDaoSelect;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckSoftDelete extends ModelCheckerTemplateAction<StowotmInfo, StowotmInfo> {

	public StowotmCheckSoftDelete(ModelCheckerOption option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> buildActionHook(DeciTreeOption<StowotmInfo> option) {
		ActionStd<StowotmInfo> enforceDel = new ActionStdCommom<StowotmInfo>(option, StowotmVisiEnforceDel.class);
		ActionLazy<StowotmInfo> select = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_FLAGGED_AS_DELETED;	
	}
}
