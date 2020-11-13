package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.info.OrdarchPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdarchPruneInactive extends ActionVisitorTemplatePruneSelf<OrdarchInfo> {
	
	public VisiOrdarchPruneInactive(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<OrdarchInfo> pruneHook(List<OrdarchInfo> recordInfos) {	
		return OrdarchPruner.pruneInactive(recordInfos);
	}
}
