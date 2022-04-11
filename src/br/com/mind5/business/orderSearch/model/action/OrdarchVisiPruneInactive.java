package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.info.OrdarchPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneSelf;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdarchVisiPruneInactive extends ActionVisitorTemplatePruneSelf<OrdarchInfo> {
	
	public OrdarchVisiPruneInactive(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<OrdarchInfo> pruneHook(List<OrdarchInfo> recordInfos) {	
		return OrdarchPruner.pruneInactive(recordInfos);
	}
}
