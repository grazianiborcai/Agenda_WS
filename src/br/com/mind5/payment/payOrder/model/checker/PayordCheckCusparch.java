package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCusparch extends ModelCheckerTemplateActionV2<PayordInfo, CusparchInfo> {
	
	public PayordCheckCusparch(ModelCheckerOption option) {
		super(option, CusparchInfo.class);
	}
	

	
	@Override protected ActionStd<CusparchInfo> buildActionHook(DeciTreeOption<CusparchInfo> option) {
		ActionStd<CusparchInfo> select = new RootCusparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CusparchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return CusparchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_DIF_CUSPAR_USER;
	}
}
