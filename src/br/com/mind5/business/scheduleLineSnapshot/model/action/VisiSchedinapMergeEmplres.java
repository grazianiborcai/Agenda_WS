package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.EmplresRootSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeEmplres extends ActionVisitorTemplateMerge<SchedinapInfo, EmplresInfo> {
	
	public VisiSchedinapMergeEmplres(DeciTreeOption<SchedinapInfo> option) {
		super(option, EmplresInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return EmplresRootSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
