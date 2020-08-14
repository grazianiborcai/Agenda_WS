package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.RootBusareaSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerMergeBusarea extends ActionVisitorTemplateMergeV2<OwnerInfo, BusareaInfo> {
	
	public VisiOwnerMergeBusarea(DeciTreeOption<OwnerInfo> option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BusareaInfo>> getTreeClassHook() {
		return RootBusareaSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<BusareaInfo> selectedInfos) {	
		return OwnerMerger.mergeWithBusarea(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
