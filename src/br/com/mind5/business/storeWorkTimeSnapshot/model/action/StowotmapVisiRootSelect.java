package br.com.mind5.business.storeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.model.decisionTree.StowotmapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmapVisiRootSelect extends ActionVisitorTemplateAction<StowotmapInfo, StowotmapInfo> {

	public StowotmapVisiRootSelect(DeciTreeOption<StowotmapInfo> option) {
		super(option, StowotmapInfo.class, StowotmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmapInfo>> getTreeClassHook() {
		return StowotmapRootSelect.class;
	}
	
	
	
	@Override protected List<StowotmapInfo> toBaseClassHook(List<StowotmapInfo> baseInfos, List<StowotmapInfo> results) {
		return results;
	}
}
