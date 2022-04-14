package br.com.mind5.business.storeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.decisionTree.StuntmarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmarchVisiRootSelect extends ActionVisitorTemplateAction<StuntmarchInfo, StuntmarchInfo> {

	public StuntmarchVisiRootSelect(DeciTreeOption<StuntmarchInfo> option) {
		super(option, StuntmarchInfo.class, StuntmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmarchInfo>> getTreeClassHook() {
		return StuntmarchRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmarchInfo> toBaseClassHook(List<StuntmarchInfo> baseInfos, List<StuntmarchInfo> results) {
		return results;
	}
}
