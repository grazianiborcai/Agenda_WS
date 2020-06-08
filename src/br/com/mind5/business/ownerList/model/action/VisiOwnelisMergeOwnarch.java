package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.decisionTree.RootOwnarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisMergeOwnarch extends ActionVisitorTemplateMergeV2<OwnelisInfo, OwnarchInfo> {
	
	public VisiOwnelisMergeOwnarch(DeciTreeOption<OwnelisInfo> option) {
		super(option, OwnarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnarchInfo>> getTreeClassHook() {
		return RootOwnarchSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> baseInfos, List<OwnarchInfo> selectedInfos) {	
		return OwnelisMerger.mergeWithOwnarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
