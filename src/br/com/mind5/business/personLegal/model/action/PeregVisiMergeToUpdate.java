package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiMergeToUpdate extends ActionVisitorTemplateMerge<PeregInfo, PeregInfo> {
	
	public PeregVisiMergeToUpdate(DeciTreeOption<PeregInfo> option) {
		super(option, PeregInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PeregInfo>> getVisitorClassHook() {
		return PeregVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PeregInfo> mergeHook(List<PeregInfo> baseInfos, List<PeregInfo> selectedInfos) {	
		return PeregMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
