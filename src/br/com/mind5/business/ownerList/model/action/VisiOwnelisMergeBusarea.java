package br.com.mind5.business.ownerList.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.RootBusareaSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnelisMergeBusarea extends ActionVisitorTemplateMergeV2<OwnelisInfo, BusareaInfo> {
	
	public VisiOwnelisMergeBusarea(DeciTreeOption<OwnelisInfo> option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BusareaInfo>> getTreeClassHook() {
		return RootBusareaSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> baseInfos, List<BusareaInfo> selectedInfos) {	
		return OwnelisMerger.mergeWithBusarea(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
