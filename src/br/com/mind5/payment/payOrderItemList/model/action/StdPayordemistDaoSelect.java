package br.com.mind5.payment.payOrderItemList.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class StdPayordemistDaoSelect extends ActionStdTemplateV2<PayordemistInfo> {

	public StdPayordemistDaoSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayordemistInfo> buildVisitorHook(DeciTreeOption<PayordemistInfo> option) {
		return new VisiPayordemistDaoSelect(option);
	}
}
