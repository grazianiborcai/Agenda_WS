package br.com.mind5.file.fileImageSearch.model.action;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimarchMergeToSelect extends ActionVisitorTemplateMergeV2<FimarchInfo, FimarchInfo> {
	
	public VisiFimarchMergeToSelect(DeciTreeOption<FimarchInfo> option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FimarchInfo>> getActionClassHook() {
		return StdFimarchDaoSelect.class;
	}
	
	
	
	@Override protected List<FimarchInfo> toActionClassHook(List<FimarchInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimarchInfo> mergeHook(List<FimarchInfo> baseInfos, List<FimarchInfo> selectedInfos) {	
		return FimarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
