package br.com.mind5.business.orderItemSearch.model.action;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemarchMergeToSelect extends ActionStdTemplateV2<OrdemarchInfo> {

	public StdOrdemarchMergeToSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdemarchInfo> buildVisitorHook(DeciTreeOption<OrdemarchInfo> option) {
		return new VisiOrdemarchMergeToSelect(option);
	}
}
