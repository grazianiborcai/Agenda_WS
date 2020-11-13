package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatmarchInfo, MatmarchInfo> {
	
	public VisiMatmarchMergeToSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatmarchInfo>> getActionClassHook() {
		return StdMatmarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatmarchInfo> mergeHook(List<MatmarchInfo> baseInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
