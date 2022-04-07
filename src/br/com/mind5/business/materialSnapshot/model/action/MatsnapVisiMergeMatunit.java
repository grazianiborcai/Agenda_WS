package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.decisionTree.RootMatunitSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatsnapVisiMergeMatunit extends ActionVisitorTemplateMerge<MatsnapInfo, MatunitInfo> {
	
	public MatsnapVisiMergeMatunit(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatunitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatunitInfo>> getTreeClassHook() {
		return RootMatunitSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MatunitInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatunit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
