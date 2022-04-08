package br.com.mind5.business.materialTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextarchVisiMergeToSelect extends ActionVisitorTemplateMerge<MatextarchInfo, MatextarchInfo> {
	
	public MatextarchVisiMergeToSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatextarchInfo>> getVisitorClassHook() {
		return MatextarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<MatextarchInfo> mergeHook(List<MatextarchInfo> baseInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
