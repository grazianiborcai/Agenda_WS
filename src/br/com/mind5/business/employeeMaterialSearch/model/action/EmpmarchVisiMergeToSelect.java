package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmarchVisiMergeToSelect extends ActionVisitorTemplateMerge<EmpmarchInfo, EmpmarchInfo> {
	
	public EmpmarchVisiMergeToSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<EmpmarchInfo>> getVisitorClassHook() {
		return EmpmarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpmarchInfo> mergeHook(List<EmpmarchInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {	
		return EmpmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
