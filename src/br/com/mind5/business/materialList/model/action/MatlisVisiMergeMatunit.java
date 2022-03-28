package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.decisionTree.RootMatunitSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiMergeMatunit extends ActionVisitorTemplateMerge<MatlisInfo, MatunitInfo> {
	
	public MatlisVisiMergeMatunit(DeciTreeOption<MatlisInfo> option) {
		super(option, MatunitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatunitInfo>> getTreeClassHook() {
		return RootMatunitSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		return MatlisMerger.mergeWithMatunit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
