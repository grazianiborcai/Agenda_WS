package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.RootMatoupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatMergeMatoup extends ActionVisitorTemplateMerge<MatInfo, MatoupInfo> {
	
	public VisiMatMergeMatoup(DeciTreeOption<MatInfo> option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupInfo>> getTreeClassHook() {
		return RootMatoupSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatoupInfo> selectedInfos) {	
		return MatMerger.mergeWithMatoup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
