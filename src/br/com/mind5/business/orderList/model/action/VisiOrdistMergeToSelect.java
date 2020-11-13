package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistMergeToSelect extends ActionVisitorTemplateMerge<OrdistInfo, OrdistInfo> {
	
	public VisiOrdistMergeToSelect(DeciTreeOption<OrdistInfo> option) {
		super(option, OrdistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdistInfo>> getActionClassHook() {
		return StdOrdistDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
