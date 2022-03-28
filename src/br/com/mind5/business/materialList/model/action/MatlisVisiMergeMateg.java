package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.decisionTree.RootMategSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiMergeMateg extends ActionVisitorTemplateMerge<MatlisInfo, MategInfo> {
	
	public MatlisVisiMergeMateg(DeciTreeOption<MatlisInfo> option) {
		super(option, MategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MategInfo>> getTreeClassHook() {
		return RootMategSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MategInfo> selectedInfos) {
		return MatlisMerger.mergeWithMateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
