package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmarchMergeToSelect extends ActionVisitorTemplateMerge<MatmarchInfo, MatmarchInfo> {
	
	public VisiMatmarchMergeToSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatmarchInfo>> getActionClassHook() {
		return StdMatmarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatmarchInfo> mergeHook(List<MatmarchInfo> baseInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
