package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmCheckExist extends ModelCheckerTemplateAction<StuntmInfo, StuntmInfo> {
	
	public StuntmCheckExist(ModelCheckerOption option) {
		super(option, StuntmInfo.class);
	}
	
	
	
	@Override protected ActionStd<StuntmInfo> buildActionHook(DeciTreeOption<StuntmInfo> option) {
		ActionStd<StuntmInfo> select = new  ActionStdCommom<StuntmInfo>(option, StuntmVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LTIME_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_NOT_FOUND;
	}
}
