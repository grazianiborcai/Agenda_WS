package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalCopier;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.decisionTree.RootMooncalSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeMooncal extends ActionVisitorTemplateMergeV2<SchedeekInfo, MooncalInfo> {
	
	public VisiSchedeekMergeMooncal(DeciTreeOption<SchedeekInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MooncalInfo>> getTreeClassHook() {
		return RootMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> toActionClassHook(List<SchedeekInfo> recordInfos) {
		return MooncalCopier.copyFromSchedeek(recordInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithMooncal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
