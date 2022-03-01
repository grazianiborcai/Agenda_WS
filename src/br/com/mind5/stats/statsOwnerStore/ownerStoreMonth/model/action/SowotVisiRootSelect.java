package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree.SowotRootSelect;

public final class SowotVisiRootSelect extends ActionVisitorTemplateAction<SowotInfo, SowotInfo> {

	public SowotVisiRootSelect(DeciTreeOption<SowotInfo> option) {
		super(option, SowotInfo.class, SowotInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotInfo>> getTreeClassHook() {
		return SowotRootSelect.class;
	}
	
	
	
	@Override protected List<SowotInfo> toBaseClassHook(List<SowotInfo> baseInfos, List<SowotInfo> results) {
		return results;
	}
}
