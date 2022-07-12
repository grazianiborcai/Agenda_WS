package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiMergeToDelete extends ActionVisitorTemplateMerge<FimgInfo, FimgInfo> {
	
	public FimgVisiMergeToDelete(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FimgInfo>> getVisitorClassHook() {
		return FimgVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
