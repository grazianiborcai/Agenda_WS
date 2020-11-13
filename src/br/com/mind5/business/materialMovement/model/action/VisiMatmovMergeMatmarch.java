package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.model.decisionTree.RootMatmarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovMergeMatmarch extends ActionVisitorTemplateMergeV2<MatmovInfo, MatmarchInfo> {
	
	public VisiMatmovMergeMatmarch(DeciTreeOption<MatmovInfo> option) {
		super(option, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatmarchInfo>> getTreeClassHook() {
		return RootMatmarchSelect.class;
	}
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> baseInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmovMerger.mergeWithMatmarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
