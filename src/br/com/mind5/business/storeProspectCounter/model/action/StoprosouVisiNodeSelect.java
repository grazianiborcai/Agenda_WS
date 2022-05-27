package br.com.mind5.business.storeProspectCounter.model.action;

import java.util.List;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.model.decisionTree.StoprosouNodeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosouVisiNodeSelect extends ActionVisitorTemplateAction<StoprosouInfo, StoprosouInfo> {

	public StoprosouVisiNodeSelect(DeciTreeOption<StoprosouInfo> option) {
		super(option, StoprosouInfo.class, StoprosouInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoprosouInfo>> getTreeClassHook() {
		return StoprosouNodeSelect.class;
	}
	
	
	
	@Override protected List<StoprosouInfo> toBaseClassHook(List<StoprosouInfo> baseInfos, List<StoprosouInfo> results) {
		return results;
	}
}
