package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.decisionTree.RootMatextsnapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapMergeMatextsnap extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatextsnapInfo> {
	
	public VisiMatsnapMergeMatextsnap(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextsnapInfo>> getTreeClassHook() {
		return RootMatextsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatextsnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
