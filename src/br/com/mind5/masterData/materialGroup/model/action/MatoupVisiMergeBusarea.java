package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.BusareaRootSelect;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupVisiMergeBusarea extends ActionVisitorTemplateMerge<MatoupInfo, BusareaInfo> {
	
	public MatoupVisiMergeBusarea(DeciTreeOption<MatoupInfo> option) {
		super(option, BusareaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BusareaInfo>> getTreeClassHook() {
		return BusareaRootSelect.class;
	}
	
	
	
	@Override protected List<MatoupInfo> mergeHook(List<MatoupInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		return MatoupMerger.mergeWithBusarea(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
