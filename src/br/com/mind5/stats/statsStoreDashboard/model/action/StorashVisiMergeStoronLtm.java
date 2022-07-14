package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.info.StorashMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree.StoronRootSelectLtm;

public final class StorashVisiMergeStoronLtm extends ActionVisitorTemplateMerge<StorashInfo, StoronInfo> {
	
	public StorashVisiMergeStoronLtm(DeciTreeOption<StorashInfo> option) {
		super(option, StoronInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronInfo>> getTreeClassHook() {
		return StoronRootSelectLtm.class;
	}
	
	
	
	@Override protected List<StorashInfo> mergeHook(List<StorashInfo> baseInfos, List<StoronInfo> selectedInfos) {	
		return StorashMerger.mergeWithStoron(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
