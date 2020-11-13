package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapMergeToSelect extends ActionVisitorTemplateMerge<OrdemrapInfo, OrdemrapInfo> {
	
	public VisiOrdemrapMergeToSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option, OrdemrapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdemrapInfo>> getActionClassHook() {
		return StdOrdemrapDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
