package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.StdCusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusCheckExist extends ModelCheckerTemplateAction<CusInfo, CusInfo> {
	
	public CusCheckExist(ModelCheckerOption option) {
		super(option, CusInfo.class);
	}
	

	
	@Override protected ActionStdV1<CusInfo> buildActionHook(DeciTreeOption<CusInfo> option) {
		ActionStdV1<CusInfo> select = new StdCusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_NOT_FOUND;
	}
}
