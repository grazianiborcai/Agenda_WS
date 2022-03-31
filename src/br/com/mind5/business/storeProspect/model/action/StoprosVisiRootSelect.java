package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.StoprosRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosVisiRootSelect extends ActionVisitorTemplateAction<StoprosInfo, StoprosInfo> {

	public StoprosVisiRootSelect(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprosInfo.class, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoprosInfo>> getTreeClassHook() {
		return StoprosRootSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> toBaseClassHook(List<StoprosInfo> baseInfos, List<StoprosInfo> results) {
		return results;
	}
}
