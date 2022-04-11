package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchCopier;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.OrdarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrdarch extends ModelCheckerTemplateAction<PayordInfo, OrdarchInfo> {
	
	public PayordCheckOrdarch(ModelCheckerOption option) {
		super(option, OrdarchInfo.class);
	}
	

	
	@Override protected ActionStd<OrdarchInfo> buildActionHook(DeciTreeOption<OrdarchInfo> option) {
		ActionStd<OrdarchInfo> select = new OrdarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<OrdarchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return OrdarchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_DIF_ORDER_USER;
	}
}
