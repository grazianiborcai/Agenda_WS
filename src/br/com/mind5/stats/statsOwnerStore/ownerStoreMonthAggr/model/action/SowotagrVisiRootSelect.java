package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree.SowotagrRootSelect;

public final class SowotagrVisiRootSelect extends ActionVisitorTemplateAction<SowotagrInfo, SowotagrInfo> {

	public SowotagrVisiRootSelect(DeciTreeOption<SowotagrInfo> option) {
		super(option, SowotagrInfo.class, SowotagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotagrInfo>> getTreeClassHook() {
		return SowotagrRootSelect.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> toBaseClassHook(List<SowotagrInfo> baseInfos, List<SowotagrInfo> results) {
		return results;
	}
}
