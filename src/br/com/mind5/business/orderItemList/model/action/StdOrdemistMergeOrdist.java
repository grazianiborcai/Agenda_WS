package br.com.mind5.business.orderItemList.model.action;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemistMergeOrdist extends ActionStdTemplate<OrdemistInfo> {

	public StdOrdemistMergeOrdist(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdemistInfo> buildVisitorHook(DeciTreeOption<OrdemistInfo> option) {
		return new VisiOrdemistMergeOrdist(option);
	}
}
