package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree.SowusagrRootSelect;

public final class SowusagrVisiRootSelect extends ActionVisitorTemplateAction<SowusagrInfo, SowusagrInfo> {

	public SowusagrVisiRootSelect(DeciTreeOption<SowusagrInfo> option) {
		super(option, SowusagrInfo.class, SowusagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusagrInfo>> getTreeClassHook() {
		return SowusagrRootSelect.class;
	}
	
	
	
	@Override protected List<SowusagrInfo> toBaseClassHook(List<SowusagrInfo> baseInfos, List<SowusagrInfo> results) {
		return results;
	}
}
