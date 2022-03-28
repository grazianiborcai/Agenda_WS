package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisCopier;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.MatlisRootSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeMatlis extends ActionVisitorTemplateMerge<SchedineInfo, MatlisInfo> {
	
	public SchedineVisiMergeMatlis(DeciTreeOption<SchedineInfo> option) {
		super(option, MatlisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return MatlisRootSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<SchedineInfo> baseInfos) {
		return MatlisCopier.copyFromSchedine(baseInfos);	
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
