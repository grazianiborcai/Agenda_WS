package br.com.mind5.business.storeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.model.decisionTree.StuntmapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmapVisiRootSelect extends ActionVisitorTemplateAction<StuntmapInfo, StuntmapInfo> {

	public StuntmapVisiRootSelect(DeciTreeOption<StuntmapInfo> option) {
		super(option, StuntmapInfo.class, StuntmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmapInfo>> getTreeClassHook() {
		return StuntmapRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmapInfo> toBaseClassHook(List<StuntmapInfo> baseInfos, List<StuntmapInfo> results) {
		return results;
	}
}
