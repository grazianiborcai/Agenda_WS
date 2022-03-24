package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.RootEmplresSelect;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemrapVisiMergeEmplres extends ActionVisitorTemplateMerge<OrdemrapInfo, EmplresInfo> {
	
	public OrdemrapVisiMergeEmplres(DeciTreeOption<OrdemrapInfo> option) {
		super(option, EmplresInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return RootEmplresSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
