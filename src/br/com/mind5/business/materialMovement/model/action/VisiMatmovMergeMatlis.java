package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovMergeMatlis extends ActionVisitorTemplateMergeV2<MatmovInfo, MatlisInfo> {
	
	public VisiMatmovMergeMatlis(DeciTreeOption<MatmovInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return MatmovMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
