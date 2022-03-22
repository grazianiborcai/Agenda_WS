package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeCuslis extends ActionVisitorTemplateMerge<SchedineInfo, CuslisInfo> {
	
	public VisiSchedineMergeCuslis(DeciTreeOption<SchedineInfo> option) {
		super(option, CuslisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
