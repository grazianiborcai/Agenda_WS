package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.info.OrdarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdarchMergeToSelect extends ActionVisitorTemplateMerge<OrdarchInfo, OrdarchInfo> {
	
	public VisiOrdarchMergeToSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdarchInfo>> getActionClassHook() {
		return StdOrdarchDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdarchInfo> mergeHook(List<OrdarchInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
