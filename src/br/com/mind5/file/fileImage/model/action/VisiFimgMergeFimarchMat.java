package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelectMat;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgMergeFimarchMat extends ActionVisitorTemplateMergeV2<FimgInfo, FimarchInfo> {
	
	public VisiFimgMergeFimarchMat(DeciTreeOption<FimgInfo> option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimarchInfo>> getTreeClassHook() {
		return RootFimarchSelectMat.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimarchInfo> selectedInfos) {	
		return FimgMerger.mergeWithFimarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
