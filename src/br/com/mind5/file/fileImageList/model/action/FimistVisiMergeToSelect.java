package br.com.mind5.file.fileImageList.model.action;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.info.FimistMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimistVisiMergeToSelect extends ActionVisitorTemplateMerge<FimistInfo, FimistInfo> {
	
	public FimistVisiMergeToSelect(DeciTreeOption<FimistInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimistInfo>> getVisitorClassHook() {
		return FimistVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<FimistInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimistInfo> mergeHook(List<FimistInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return FimistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
