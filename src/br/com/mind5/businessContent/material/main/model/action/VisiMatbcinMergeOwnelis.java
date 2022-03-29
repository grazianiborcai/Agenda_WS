package br.com.mind5.businessContent.material.main.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.OwnelisRootSelect;
import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.info.MatbcinMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcinMergeOwnelis extends ActionVisitorTemplateMerge<MatbcinInfo, OwnelisInfo> {
	
	public VisiMatbcinMergeOwnelis(DeciTreeOption<MatbcinInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return OwnelisRootSelect.class;
	}
	
	
	
	@Override protected List<MatbcinInfo> mergeHook(List<MatbcinInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return MatbcinMerger.mergeWithOwnelis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
