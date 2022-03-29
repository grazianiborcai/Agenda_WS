package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.OrdistRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeMerger;

final class VisiStusorygeMergeOrdist extends ActionVisitorTemplateMerge<StusorygeInfo, OrdistInfo> {
	
	public VisiStusorygeMergeOrdist(DeciTreeOption<StusorygeInfo> option) {
		super(option, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return OrdistRootSelect.class;
	}
	
	
	
	@Override protected List<StusorygeInfo> mergeHook(List<StusorygeInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return StusorygeMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
