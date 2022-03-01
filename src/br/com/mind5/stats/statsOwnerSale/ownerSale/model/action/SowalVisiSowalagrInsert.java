package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalMerger;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.decisionTree.SowalagrRootInsert;

public final class SowalVisiSowalagrInsert extends ActionVisitorTemplateAction<SowalInfo, SowalagrInfo> {

	public SowalVisiSowalagrInsert(DeciTreeOption<SowalInfo> option) {
		super(option, SowalInfo.class, SowalagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalagrInfo>> getTreeClassHook() {
		return SowalagrRootInsert.class;
	}
	
	
	
	@Override protected List<SowalInfo> toBaseClassHook(List<SowalInfo> baseInfos, List<SowalagrInfo> results) {
		return SowalMerger.mergeWithSowalagr(baseInfos, results);
	}
}
