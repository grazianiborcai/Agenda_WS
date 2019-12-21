package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.StdCusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusCheckExist extends ModelCheckerTemplateActionV2<CusInfo, CusInfo> {
	
	public CusCheckExist(ModelCheckerOption option) {
		super(option, CusInfo.class);
	}
	

	
	@Override protected ActionStd<CusInfo> buildActionHook(DeciTreeOption<CusInfo> option) {
		ActionStd<CusInfo> select = new StdCusSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_NOT_FOUND;
	}
}
