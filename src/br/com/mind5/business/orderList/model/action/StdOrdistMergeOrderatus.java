package br.com.mind5.business.orderList.model.action;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistMergeOrderatus extends ActionStdTemplateV2<OrdistInfo> {

	public StdOrdistMergeOrderatus(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdistInfo> buildVisitorHook(DeciTreeOption<OrdistInfo> option) {
		return new VisiOrdistMergeOrderatus(option);
	}
}
