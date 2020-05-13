package br.com.mind5.business.orderItemList.model.action;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemistMergeToSelect extends ActionStdTemplateV2<OrdemistInfo> {

	public StdOrdemistMergeToSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdemistInfo> buildVisitorHook(DeciTreeOption<OrdemistInfo> option) {
		return new VisiOrdemistMergeToSelect(option);
	}
}
