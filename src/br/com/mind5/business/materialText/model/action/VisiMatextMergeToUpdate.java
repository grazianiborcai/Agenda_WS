package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextMergeToUpdate extends ActionVisitorTemplateMerge<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToUpdate(DeciTreeOption<MatextInfo> option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextInfo>> getActionClassHook() {
		return StdMatextDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
