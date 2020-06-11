package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgMergeToDelete extends ActionVisitorTemplateMergeV2<FimgInfo, FimgInfo> {
	
	public VisiFimgMergeToDelete(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FimgInfo>> getActionClassHook() {
		return StdFimgDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
