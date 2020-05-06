package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistMergeToSelect extends ActionVisitorTemplateMergeV2<OrdistInfo, OrdistInfo> {
	
	public VisiOrdistMergeToSelect(DeciTreeOption<OrdistInfo> option) {
		super(option, OrdistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrdistInfo>> getActionClassHook() {
		return StdOrdistDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
