package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.decisionTree.OwnarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchVisiRootSelect extends ActionVisitorTemplateAction<OwnarchInfo, OwnarchInfo> {

	public OwnarchVisiRootSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option, OwnarchInfo.class, OwnarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnarchInfo>> getTreeClassHook() {
		return OwnarchRootSelect.class;
	}
	
	
	
	@Override protected List<OwnarchInfo> toBaseClassHook(List<OwnarchInfo> baseInfos, List<OwnarchInfo> results) {
		return results;
	}
}
