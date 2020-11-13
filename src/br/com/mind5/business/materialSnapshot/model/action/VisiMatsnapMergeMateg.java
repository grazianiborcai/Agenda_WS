package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.decisionTree.RootMategSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapMergeMateg extends ActionVisitorTemplateMerge<MatsnapInfo, MategInfo> {
	
	public VisiMatsnapMergeMateg(DeciTreeOption<MatsnapInfo> option) {
		super(option, MategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MategInfo>> getTreeClassHook() {
		return RootMategSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MategInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
