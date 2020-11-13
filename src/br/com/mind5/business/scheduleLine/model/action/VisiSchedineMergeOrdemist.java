package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.RootOrdemistSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeOrdemist extends ActionVisitorTemplateMerge<SchedineInfo, OrdemistInfo> {
	
	public VisiSchedineMergeOrdemist(DeciTreeOption<SchedineInfo> option) {
		super(option, OrdemistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return RootOrdemistSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return SchedineMerger.mergeWithOrdemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
