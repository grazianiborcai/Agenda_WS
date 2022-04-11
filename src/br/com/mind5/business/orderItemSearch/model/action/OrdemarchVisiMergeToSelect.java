package br.com.mind5.business.orderItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemarchVisiMergeToSelect extends ActionVisitorTemplateMerge<OrdemarchInfo, OrdemarchInfo> {
	
	public OrdemarchVisiMergeToSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrdemarchInfo>> getVisitorClassHook() {
		return OrdemarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemarchInfo> mergeHook(List<OrdemarchInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrdemarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
