package br.com.mind5.file.fileImageList.model.action;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.info.FimistMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimistMergeToSelect extends ActionVisitorTemplateMergeV2<FimistInfo, FimistInfo> {
	
	public VisiFimistMergeToSelect(DeciTreeOption<FimistInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FimistInfo>> getActionClassHook() {
		return StdFimistDaoSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<FimistInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimistInfo> mergeHook(List<FimistInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return FimistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
