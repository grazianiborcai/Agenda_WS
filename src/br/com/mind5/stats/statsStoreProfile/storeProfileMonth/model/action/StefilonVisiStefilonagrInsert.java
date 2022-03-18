package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonMerger;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.decisionTree.StefilonagrRootInsert;

public final class StefilonVisiStefilonagrInsert extends ActionVisitorTemplateAction<StefilonInfo, StefilonagrInfo> {

	public StefilonVisiStefilonagrInsert(DeciTreeOption<StefilonInfo> option) {
		super(option, StefilonInfo.class, StefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonagrInfo>> getTreeClassHook() {
		return StefilonagrRootInsert.class;
	}
	
	
	
	@Override protected List<StefilonInfo> toBaseClassHook(List<StefilonInfo> baseInfos, List<StefilonagrInfo> results) {
		return StefilonMerger.mergeWithStedmonagr(baseInfos, results);
	}
}
