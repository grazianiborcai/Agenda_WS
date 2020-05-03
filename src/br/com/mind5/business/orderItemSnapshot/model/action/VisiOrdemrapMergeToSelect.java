package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapMergeToSelect extends ActionVisitorTemplateMergeV2<OrdemrapInfo, OrdemrapInfo> {
	
	public VisiOrdemrapMergeToSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option, OrdemrapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrdemrapInfo>> getActionClassHook() {
		return StdOrdemrapDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
