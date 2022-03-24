package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemrapVisiMergeToSelect extends ActionVisitorTemplateMerge<OrdemrapInfo, OrdemrapInfo> {
	
	public OrdemrapVisiMergeToSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option, OrdemrapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrdemrapInfo>> getVisitorClassHook() {
		return OrdemrapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
