package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiRootSelect extends ActionVisitorTemplateAction<StuntmInfo, StuntmInfo> {

	public StuntmVisiRootSelect(DeciTreeOption<StuntmInfo> option) {
		super(option, StuntmInfo.class, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmInfo>> getTreeClassHook() {
		return StuntmRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmInfo> toBaseClassHook(List<StuntmInfo> baseInfos, List<StuntmInfo> results) {
		return results;
	}
}
