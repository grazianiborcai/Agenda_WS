package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresCopier;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.RootEmplresSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeEmplres extends ActionVisitorTemplateMerge<SchedineInfo, EmplresInfo> {
	
	public VisiSchedineMergeEmplres(DeciTreeOption<SchedineInfo> option) {
		super(option, EmplresInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return RootEmplresSelect.class;
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
