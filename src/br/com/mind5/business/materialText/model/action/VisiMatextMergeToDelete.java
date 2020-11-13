package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextMergeToDelete extends ActionVisitorTemplateMerge<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToDelete(DeciTreeOption<MatextInfo> option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextInfo>> getActionClassHook() {
		return StdMatextDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
