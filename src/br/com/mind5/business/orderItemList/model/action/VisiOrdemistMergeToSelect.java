package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.info.OrdemistMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemistMergeToSelect extends ActionVisitorTemplateMergeV2<OrdemistInfo, OrdemistInfo> {
	
	public VisiOrdemistMergeToSelect(DeciTreeOption<OrdemistInfo> option) {
		super(option, OrdemistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrdemistInfo>> getActionClassHook() {
		return StdOrdemistDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemistInfo> mergeHook(List<OrdemistInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return OrdemistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
