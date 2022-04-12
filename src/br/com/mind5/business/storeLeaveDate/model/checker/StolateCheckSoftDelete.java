package br.com.mind5.business.storeLeaveDate.model.checker;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiDaoSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckSoftDelete extends ModelCheckerTemplateAction<StolateInfo, StolateInfo> {
	
	public StolateCheckSoftDelete(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStd<StolateInfo> enforceDel = new ActionStdCommom<StolateInfo>(option, StolateVisiEnforceDel.class);
		ActionLazy<StolateInfo> selectKey = new ActionLazyCommom<StolateInfo>(option, StolateVisiDaoSelect.class);		
		
		enforceDel.addPostAction(selectKey);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;
	}
}
