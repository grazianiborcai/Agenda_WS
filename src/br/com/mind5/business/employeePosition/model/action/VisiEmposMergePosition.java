package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.decisionTree.RootPositionSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposMergePosition extends ActionVisitorTemplateMerge<EmposInfo, PositionInfo> {
	
	public VisiEmposMergePosition(DeciTreeOption<EmposInfo> option) {
		super(option, PositionInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PositionInfo>> getTreeClassHook() {
		return RootPositionSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<PositionInfo> selectedInfos) {	
		return EmposMerger.mergeWithPosition(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
