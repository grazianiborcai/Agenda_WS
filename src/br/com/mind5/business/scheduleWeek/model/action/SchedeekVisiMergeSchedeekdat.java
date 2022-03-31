package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatCopier;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.decisionTree.RootSchedeekdatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiMergeSchedeekdat extends ActionVisitorTemplateMerge<SchedeekInfo, SchedeekdatInfo> {
	
	public SchedeekVisiMergeSchedeekdat(DeciTreeOption<SchedeekInfo> option) {
		super(option, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedeekdatInfo>> getTreeClassHook() {
		return RootSchedeekdatSelect.class;
	}
	
	
	
	@Override protected List<SchedeekdatInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return SchedeekdatCopier.copyFromSchedeek(baseInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithSchedeekdat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
