package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree.SowotagrRootDelete;

public final class SowotagrVisiRootDelete extends ActionVisitorTemplateAction<SowotagrInfo, SowotagrInfo> {

	public SowotagrVisiRootDelete(DeciTreeOption<SowotagrInfo> option) {
		super(option, SowotagrInfo.class, SowotagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotagrInfo>> getTreeClassHook() {
		return SowotagrRootDelete.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> toBaseClassHook(List<SowotagrInfo> baseInfos, List<SowotagrInfo> results) {
		return results;
	}
}
