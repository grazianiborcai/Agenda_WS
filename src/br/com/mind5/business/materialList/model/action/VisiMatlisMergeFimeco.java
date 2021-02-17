package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.RootFimecoSelectByMat;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatlisMergeFimeco extends ActionVisitorTemplateMerge<MatlisInfo, FimecoInfo> {
	
	public VisiMatlisMergeFimeco(DeciTreeOption<MatlisInfo> option) {
		super(option, FimecoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimecoInfo>> getTreeClassHook() {
		return RootFimecoSelectByMat.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		return MatlisMerger.mergeWithFimeco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
