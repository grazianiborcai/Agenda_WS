package br.com.mind5.business.materialStock.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.info.MatockMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatockMergeToSelect extends ActionVisitorTemplateMergeV2<MatockInfo, MatockInfo> {
	
	public VisiMatockMergeToSelect(DeciTreeOption<MatockInfo> option) {
		super(option, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<MatockInfo>> getActionClassHook() {
		return StdMatockDaoSelect.class;
	}
	
	
	
	@Override protected List<MatockInfo> mergeHook(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {	
		return MatockMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
