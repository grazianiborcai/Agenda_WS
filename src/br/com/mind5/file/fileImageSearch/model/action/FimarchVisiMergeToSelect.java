package br.com.mind5.file.fileImageSearch.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimarchVisiMergeToSelect extends ActionVisitorTemplateMerge<FimarchInfo, FimarchInfo> {
	
	public FimarchVisiMergeToSelect(DeciTreeOption<FimarchInfo> option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimarchInfo>> getVisitorClassHook() {
		return FimarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FimarchInfo> toActionClassHook(List<FimarchInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimarchInfo> mergeHook(List<FimarchInfo> baseInfos, List<FimarchInfo> selectedInfos) {	
		return FimarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
