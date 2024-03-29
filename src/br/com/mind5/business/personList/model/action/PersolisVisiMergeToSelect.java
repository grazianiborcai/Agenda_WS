package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersolisVisiMergeToSelect extends ActionVisitorTemplateMerge<PersolisInfo, PersolisInfo> {
	
	public PersolisVisiMergeToSelect(DeciTreeOption<PersolisInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PersolisInfo>> getVisitorClassHook() {
		return PersolisVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PersolisInfo> mergeHook(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return PersolisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
