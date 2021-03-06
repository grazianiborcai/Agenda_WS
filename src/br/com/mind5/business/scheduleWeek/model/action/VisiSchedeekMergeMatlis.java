package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisCopier;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeMatlis extends ActionVisitorTemplateMerge<SchedeekInfo, MatlisInfo> {
	
	public VisiSchedeekMergeMatlis(DeciTreeOption<SchedeekInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return MatlisCopier.copyFromSchedeek(baseInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
