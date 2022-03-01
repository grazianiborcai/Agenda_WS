package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.decisionTree.SowotarchRootSelect;

public final class SowotarchVisiRootSelect extends ActionVisitorTemplateAction<SowotarchInfo, SowotarchInfo> {

	public SowotarchVisiRootSelect(DeciTreeOption<SowotarchInfo> option) {
		super(option, SowotarchInfo.class, SowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotarchInfo>> getTreeClassHook() {
		return SowotarchRootSelect.class;
	}
	
	
	
	@Override protected List<SowotarchInfo> toBaseClassHook(List<SowotarchInfo> baseInfos, List<SowotarchInfo> results) {
		return results;
	}
}
