package br.com.mind5.business.storeLeaveDateRange.model.checker;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.decisionTree.StolargRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolargCheckExist extends ModelCheckerTemplateAction<StolargInfo, StolargInfo> {
	
	public StolargCheckExist(ModelCheckerOption option) {
		super(option, StolargInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolargInfo> buildActionHook(DeciTreeOption<StolargInfo> option) {
		ActionStd<StolargInfo> select = new StolargRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_RANGE_NOT_FOUND;
	}
}
