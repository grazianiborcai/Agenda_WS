package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgMergeToSelect extends ActionVisitorTemplateMerge<FimgInfo, FimgInfo> {
	
	public VisiFimgMergeToSelect(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgInfo>> getActionClassHook() {
		return StdFimgDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> toActionClassHook(List<FimgInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
