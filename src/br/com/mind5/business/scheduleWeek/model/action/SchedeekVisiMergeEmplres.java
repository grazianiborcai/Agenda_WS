package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresCopier;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.EmplresRootSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiMergeEmplres extends ActionVisitorTemplateMerge<SchedeekInfo, EmplresInfo> {
	
	public SchedeekVisiMergeEmplres(DeciTreeOption<SchedeekInfo> option) {
		super(option, EmplresInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return EmplresRootSelect.class;
	}
	
	
	
	@Override protected List<EmplresInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return EmplresCopier.copyFromSchedeek(baseInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
