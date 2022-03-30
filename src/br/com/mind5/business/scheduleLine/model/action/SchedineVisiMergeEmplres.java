package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresCopier;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.EmplresRootSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeEmplres extends ActionVisitorTemplateMerge<SchedineInfo, EmplresInfo> {
	
	public SchedineVisiMergeEmplres(DeciTreeOption<SchedineInfo> option) {
		super(option, EmplresInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return EmplresRootSelect.class;
	}
	
	
	
	@Override protected List<EmplresInfo> toActionClassHook(List<SchedineInfo> baseInfos) {
		return EmplresCopier.copyFromSchedine(baseInfos);	
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return SchedineMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
