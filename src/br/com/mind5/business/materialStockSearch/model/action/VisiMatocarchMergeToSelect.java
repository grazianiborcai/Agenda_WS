package br.com.mind5.business.materialStockSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.materialStockSearch.info.MatocarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatocarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatocarchInfo, MatocarchInfo> {
	
	public VisiMatocarchMergeToSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option, MatocarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatocarchInfo>> getActionClassHook() {
		return StdMatocarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatocarchInfo> mergeHook(List<MatocarchInfo> baseInfos, List<MatocarchInfo> selectedInfos) {	
		return MatocarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
