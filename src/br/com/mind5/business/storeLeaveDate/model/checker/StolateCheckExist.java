package br.com.mind5.business.storeLeaveDate.model.checker;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckExist extends ModelCheckerTemplateAction<StolateInfo, StolateInfo> {
	
	public StolateCheckExist(ModelCheckerOption option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(DeciTreeOption<StolateInfo> option) {
		ActionStd<StolateInfo> select = new ActionStdCommom<StolateInfo>(option, StolateVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_NOT_FOUND;
	}
}
