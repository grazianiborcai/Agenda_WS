package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.decisionTree.RootFimgysSelectGroup;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoupMergeFimgys extends ActionVisitorTemplateMerge<MatoupInfo, FimgysInfo> {
	
	public VisiMatoupMergeFimgys(DeciTreeOption<MatoupInfo> option) {
		super(option, FimgysInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysInfo>> getTreeClassHook() {
		return RootFimgysSelectGroup.class;
	}
	
	
	
	@Override protected List<MatoupInfo> mergeHook(List<MatoupInfo> baseInfos, List<FimgysInfo> selectedInfos) {
		return MatoupMerger.mergeWithFimgys(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
