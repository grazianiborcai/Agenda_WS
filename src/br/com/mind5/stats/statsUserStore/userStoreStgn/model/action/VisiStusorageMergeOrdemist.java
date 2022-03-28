package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.OrdemistRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageMerger;

final class VisiStusorageMergeOrdemist extends ActionVisitorTemplateMerge<StusorageInfo, OrdemistInfo> {
	
	public VisiStusorageMergeOrdemist(DeciTreeOption<StusorageInfo> option) {
		super(option, OrdemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return OrdemistRootSelect.class;
	}
	
	
	
	@Override protected List<StusorageInfo> mergeHook(List<StusorageInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return StusorageMerger.mergeWithOrdemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
