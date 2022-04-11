package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.OrdarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdarchVisiRootSelect extends ActionVisitorTemplateAction<OrdarchInfo, OrdarchInfo> {

	public OrdarchVisiRootSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option, OrdarchInfo.class, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdarchInfo>> getTreeClassHook() {
		return OrdarchRootSelect.class;
	}
	
	
	
	@Override protected List<OrdarchInfo> toBaseClassHook(List<OrdarchInfo> baseInfos, List<OrdarchInfo> results) {
		return results;
	}
}
