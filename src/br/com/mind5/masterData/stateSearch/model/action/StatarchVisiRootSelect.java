package br.com.mind5.masterData.stateSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.decisionTree.StatarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchVisiRootSelect extends ActionVisitorTemplateAction<StatarchInfo, StatarchInfo> {

	public StatarchVisiRootSelect(DeciTreeOption<StatarchInfo> option) {
		super(option, StatarchInfo.class, StatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StatarchInfo>> getTreeClassHook() {
		return StatarchRootSelect.class;
	}
	
	
	
	@Override protected List<StatarchInfo> toBaseClassHook(List<StatarchInfo> baseInfos, List<StatarchInfo> results) {
		return results;
	}
}
