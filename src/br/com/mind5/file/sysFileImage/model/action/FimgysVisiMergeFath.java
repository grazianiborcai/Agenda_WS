package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.decisionTree.FathRootSelectImage;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.info.FimgysMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiMergeFath extends ActionVisitorTemplateMerge<FimgysInfo, FathInfo> {
	
	public FimgysVisiMergeFath(DeciTreeOption<FimgysInfo> option) {
		super(option, FathInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FathInfo>> getTreeClassHook() {
		return FathRootSelectImage.class;
	}
	
	
	
	@Override protected List<FimgysInfo> mergeHook(List<FimgysInfo> baseInfos, List<FathInfo> selectedInfos) {	
		return FimgysMerger.mergeWithFath(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
