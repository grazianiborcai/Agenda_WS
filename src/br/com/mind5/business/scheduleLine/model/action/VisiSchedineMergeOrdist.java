package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeOrdist extends ActionVisitorTemplateMergeV2<SchedineInfo, OrdistInfo> {
	
	public VisiSchedineMergeOrdist(DeciTreeOption<SchedineInfo> option) {
		super(option, OrdistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return RootOrdistSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return SchedineMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
