package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree.SowotagrRootDeleteMonth;

public final class SowotVisiSowotagrDeleteMonth extends ActionVisitorTemplateAction<SowotInfo, SowotagrInfo> {

	public SowotVisiSowotagrDeleteMonth(DeciTreeOption<SowotInfo> option) {
		super(option, SowotInfo.class, SowotagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotagrInfo>> getTreeClassHook() {
		return SowotagrRootDeleteMonth.class;
	}
	
	
	
	@Override protected List<SowotInfo> toBaseClassHook(List<SowotInfo> baseInfos, List<SowotagrInfo> results) {
		return baseInfos;
	}
}
