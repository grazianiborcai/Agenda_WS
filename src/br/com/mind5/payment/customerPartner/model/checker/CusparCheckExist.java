package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.StdCusparSelect;

public final class CusparCheckExist extends ModelCheckerTemplateActionV2<CusparInfo, CusparInfo> {
	
	public CusparCheckExist(ModelCheckerOption option) {
		super(option, CusparInfo.class);
	}
	

	
	@Override protected ActionStdV1<CusparInfo> buildActionHook(DeciTreeOption<CusparInfo> option) {
		ActionStdV1<CusparInfo> select = new StdCusparSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_CUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_NOT_FOUND;
	}
}
