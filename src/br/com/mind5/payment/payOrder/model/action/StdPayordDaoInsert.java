package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class StdPayordDaoInsert extends ActionStdTemplateV2<PayordInfo> {

	public StdPayordDaoInsert(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayordInfo> buildVisitorHook(DeciTreeOption<PayordInfo> option) {
		return new VisiPayordDaoInsert(option);
	}
}
