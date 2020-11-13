package br.com.mind5.business.storeLeaveDateRange.model.checker;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.decisionTree.RootStolargSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolargCheckExist extends ModelCheckerTemplateActionV2<StolargInfo, StolargInfo> {
	
	public StolargCheckExist(ModelCheckerOption option) {
		super(option, StolargInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StolargInfo> buildActionHook(DeciTreeOption<StolargInfo> option) {
		ActionStdV2<StolargInfo> select = new RootStolargSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_RANGE_NOT_FOUND;
	}
}
