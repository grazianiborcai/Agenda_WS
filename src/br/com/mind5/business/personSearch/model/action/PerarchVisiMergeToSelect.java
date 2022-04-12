package br.com.mind5.business.personSearch.model.action;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchVisiMergeToSelect extends ActionVisitorTemplateMerge<PerarchInfo, PerarchInfo> {
	
	public PerarchVisiMergeToSelect(DeciTreeOption<PerarchInfo> option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PerarchInfo>> getVisitorClassHook() {
		return PerarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> mergeHook(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {	
		return PerarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
