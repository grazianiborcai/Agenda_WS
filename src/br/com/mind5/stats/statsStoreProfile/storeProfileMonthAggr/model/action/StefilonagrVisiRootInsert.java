package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.decisionTree.StefilonagrRootInsert;

public final class StefilonagrVisiRootInsert extends ActionVisitorTemplateAction<StefilonagrInfo, StefilonagrInfo> {

	public StefilonagrVisiRootInsert(DeciTreeOption<StefilonagrInfo> option) {
		super(option, StefilonagrInfo.class, StefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonagrInfo>> getTreeClassHook() {
		return StefilonagrRootInsert.class;
	}
	
	
	
	@Override protected List<StefilonagrInfo> toBaseClassHook(List<StefilonagrInfo> baseInfos, List<StefilonagrInfo> results) {
		return results;
	}
}
