package br.com.mind5.business.materialSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatarchVisiMergeToSelect extends ActionVisitorTemplateMerge<MatarchInfo, MatarchInfo> {
	
	public MatarchVisiMergeToSelect(DeciTreeOption<MatarchInfo> option) {
		super(option, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatarchInfo>> getVisitorClassHook() {
		return MatarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatarchInfo> mergeHook(List<MatarchInfo> baseInfos, List<MatarchInfo> selectedInfos) {	
		return MatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
