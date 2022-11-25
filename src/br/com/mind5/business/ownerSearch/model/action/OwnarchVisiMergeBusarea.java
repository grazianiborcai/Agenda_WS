package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.BusareaRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchVisiMergeBusarea extends ActionVisitorTemplateMerge<OwnarchInfo, BusareaInfo> {
	
	public OwnarchVisiMergeBusarea(DeciTreeOption<OwnarchInfo> option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BusareaInfo>> getTreeClassHook() {
		return BusareaRootSelect.class;
	}
	
	
	
	@Override protected List<OwnarchInfo> mergeHook(List<OwnarchInfo> baseInfos, List<BusareaInfo> selectedInfos) {	
		return OwnarchMerger.mergeWithBusarea(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
