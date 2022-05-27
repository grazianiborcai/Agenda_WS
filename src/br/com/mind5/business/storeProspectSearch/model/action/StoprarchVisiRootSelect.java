package br.com.mind5.business.storeProspectSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.decisionTree.StoprarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprarchVisiRootSelect extends ActionVisitorTemplateAction<StoprarchInfo, StoprarchInfo> {

	public StoprarchVisiRootSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option, StoprarchInfo.class, StoprarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoprarchInfo>> getTreeClassHook() {
		return StoprarchRootSelect.class;
	}
	
	
	
	@Override protected List<StoprarchInfo> toBaseClassHook(List<StoprarchInfo> baseInfos, List<StoprarchInfo> results) {
		return results;
	}
}
