package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.RootCrecarchSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecarch extends ModelCheckerTemplateActionV2<PayordInfo, CrecarchInfo> {
	
	public PayordCheckCrecarch(ModelCheckerOption option) {
		super(option, CrecarchInfo.class);
	}
	

	
	@Override protected ActionStdV2<CrecarchInfo> buildActionHook(DeciTreeOption<CrecarchInfo> option) {
		ActionStdV2<CrecarchInfo> select = new RootCrecarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CrecarchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return CrecarchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_CRECARD_DIF_USER;
	}
}
