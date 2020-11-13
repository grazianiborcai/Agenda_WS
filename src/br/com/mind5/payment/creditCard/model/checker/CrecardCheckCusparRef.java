package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelect;

public final class CrecardCheckCusparRef extends ModelCheckerTemplateActionV2<CrecardInfo, CusparchInfo> {

	public CrecardCheckCusparRef(ModelCheckerOption option) {
		super(option, CusparchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CusparchInfo> buildActionHook(DeciTreeOption<CusparchInfo> option) {
		ActionStdV2<CusparchInfo> select = new RootCusparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CusparchInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return CusparchCopier.copyFromCrecardRef(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_INVALID_USER_REF;
	}
}
