package br.com.mind5.business.scheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresCopier;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.EmplresRootSelect;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedmonMergeEmplres extends ActionVisitorTemplateMerge<SchedmonInfo, EmplresInfo> {
	
	public VisiSchedmonMergeEmplres(DeciTreeOption<SchedmonInfo> option) {
		super(option, EmplresInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return EmplresRootSelect.class;
	}
	
	
	
	@Override protected List<EmplresInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return EmplresCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
