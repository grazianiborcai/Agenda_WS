package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.decisionTree.RootFathSelectImage;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgMergeFath extends ActionVisitorTemplateMerge<FimgInfo, FathInfo> {
	
	public VisiFimgMergeFath(DeciTreeOption<FimgInfo> option) {
		super(option, FathInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FathInfo>> getTreeClassHook() {
		return RootFathSelectImage.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FathInfo> selectedInfos) {	
		return FimgMerger.mergeWithFath(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
