package br.com.mind5.payment.customerPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class StdCusparchMergeToSelect extends ActionStdTemplateV2<CusparchInfo> {

	public StdCusparchMergeToSelect(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusparchInfo> buildVisitorHook(DeciTreeOption<CusparchInfo> option) {
		return new VisiCusparchMergeToSelect(option);
	}
}
