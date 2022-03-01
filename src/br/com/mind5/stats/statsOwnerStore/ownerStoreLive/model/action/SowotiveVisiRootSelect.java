package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.decisionTree.SowotiveRootSelect;

public final class SowotiveVisiRootSelect extends ActionVisitorTemplateAction<SowotiveInfo, SowotiveInfo> {

	public SowotiveVisiRootSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option, SowotiveInfo.class, SowotiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotiveInfo>> getTreeClassHook() {
		return SowotiveRootSelect.class;
	}
	
	
	
	@Override protected List<SowotiveInfo> toBaseClassHook(List<SowotiveInfo> baseInfos, List<SowotiveInfo> results) {
		return results;
	}
}
