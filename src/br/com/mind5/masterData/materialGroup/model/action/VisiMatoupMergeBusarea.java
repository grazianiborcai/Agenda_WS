package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.RootBusareaSelect;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoupMergeBusarea extends ActionVisitorTemplateMerge<MatoupInfo, BusareaInfo> {
	
	public VisiMatoupMergeBusarea(DeciTreeOption<MatoupInfo> option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BusareaInfo>> getTreeClassHook() {
		return RootBusareaSelect.class;
	}
	
	
	
	@Override protected List<MatoupInfo> mergeHook(List<MatoupInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		return MatoupMerger.mergeWithBusarea(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
