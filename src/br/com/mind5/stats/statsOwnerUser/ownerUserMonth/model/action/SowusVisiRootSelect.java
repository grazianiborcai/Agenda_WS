package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree.SowusRootSelect;

public final class SowusVisiRootSelect extends ActionVisitorTemplateAction<SowusInfo, SowusInfo> {

	public SowusVisiRootSelect(DeciTreeOption<SowusInfo> option) {
		super(option, SowusInfo.class, SowusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusInfo>> getTreeClassHook() {
		return SowusRootSelect.class;
	}
	
	
	
	@Override protected List<SowusInfo> toBaseClassHook(List<SowusInfo> baseInfos, List<SowusInfo> results) {
		return results;
	}
}
