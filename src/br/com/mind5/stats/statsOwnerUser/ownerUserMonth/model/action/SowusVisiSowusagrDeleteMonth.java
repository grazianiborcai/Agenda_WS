package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree.SowusagrRootDeleteMonth;

public final class SowusVisiSowusagrDeleteMonth extends ActionVisitorTemplateAction<SowusInfo, SowusagrInfo> {

	public SowusVisiSowusagrDeleteMonth(DeciTreeOption<SowusInfo> option) {
		super(option, SowusInfo.class, SowusagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusagrInfo>> getTreeClassHook() {
		return SowusagrRootDeleteMonth.class;
	}
	
	
	
	@Override protected List<SowusInfo> toBaseClassHook(List<SowusInfo> baseInfos, List<SowusagrInfo> results) {
		return baseInfos;
	}
}
