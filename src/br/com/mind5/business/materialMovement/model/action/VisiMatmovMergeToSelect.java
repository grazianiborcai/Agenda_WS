package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovMergeToSelect extends ActionVisitorTemplateMerge<MatmovInfo, MatmovInfo> {
	
	public VisiMatmovMergeToSelect(DeciTreeOption<MatmovInfo> option) {
		super(option, MatmovInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatmovInfo>> getActionClassHook() {
		return StdMatmovDaoSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> baseInfos, List<MatmovInfo> selectedInfos) {	
		return MatmovMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
