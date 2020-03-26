package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.RootCrecarchSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecarch extends ModelCheckerTemplateAction<PayordInfo, CrecarchInfo> {
	
	public PayordCheckCrecarch(ModelCheckerOption option) {
		super(option, CrecarchInfo.class);
	}
	

	
	@Override protected ActionStd<CrecarchInfo> buildActionHook(DeciTreeOption<CrecarchInfo> option) {
		ActionStd<CrecarchInfo> select = new RootCrecarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CrecarchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return CrecarchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_CRECARD_DIF_USER;
	}
}
