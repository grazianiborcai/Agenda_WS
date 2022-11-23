package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.OwnelisRootSelect;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiMergeOwnelis extends ActionVisitorTemplateMerge<MatoupowInfo, OwnelisInfo> {
	
	public MatoupowVisiMergeOwnelis(DeciTreeOption<MatoupowInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return OwnelisRootSelect.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> mergeHook(List<MatoupowInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		return MatoupowMerger.mergeWithOwnelis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
