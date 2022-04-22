package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.StowotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotarchVisiRootSelect extends ActionVisitorTemplateAction<StowotarchInfo, StowotarchInfo> {

	public StowotarchVisiRootSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option, StowotarchInfo.class, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotarchInfo>> getTreeClassHook() {
		return StowotarchRootSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> toBaseClassHook(List<StowotarchInfo> baseInfos, List<StowotarchInfo> results) {
		return results;
	}
}
