package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchCopier;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrdarch extends ModelCheckerTemplateAction<PayordInfo, OrdarchInfo> {
	
	public PayordCheckOrdarch(ModelCheckerOption option) {
		super(option, OrdarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<OrdarchInfo> buildActionHook(DeciTreeOption<OrdarchInfo> option) {
		ActionStdV1<OrdarchInfo> select = new RootOrdarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<OrdarchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return OrdarchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_DIF_ORDER_USER;
	}
}
