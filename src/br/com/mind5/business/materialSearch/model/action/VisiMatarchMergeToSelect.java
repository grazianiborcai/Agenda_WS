package br.com.mind5.business.materialSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatarchInfo, MatarchInfo> {
	
	public VisiMatarchMergeToSelect(DeciTreeOption<MatarchInfo> option) {
		super(option, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatarchInfo>> getActionClassHook() {
		return StdMatarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatarchInfo> mergeHook(List<MatarchInfo> baseInfos, List<MatarchInfo> selectedInfos) {	
		return MatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
