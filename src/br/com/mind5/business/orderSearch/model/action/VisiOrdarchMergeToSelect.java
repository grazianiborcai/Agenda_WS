package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.info.OrdarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdarchMergeToSelect extends ActionVisitorTemplateMergeV2<OrdarchInfo, OrdarchInfo> {
	
	public VisiOrdarchMergeToSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrdarchInfo>> getActionClassHook() {
		return StdOrdarchDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdarchInfo> mergeHook(List<OrdarchInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
