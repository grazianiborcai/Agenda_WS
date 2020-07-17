package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatMergeToUpdate extends ActionVisitorTemplateMergeV2<MatInfo, MatInfo> {
	
	public VisiMatMergeToUpdate(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatInfo>> getActionClassHook() {
		return StdMatDaoSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {	
		return MatMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
