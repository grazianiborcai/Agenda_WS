package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.MatarchRootSelectAuth;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiMergeMatarch extends ActionVisitorTemplateMerge<MatlisInfo, MatarchInfo> {
	
	public MatlisVisiMergeMatarch(DeciTreeOption<MatlisInfo> option) {
		super(option, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatarchInfo>> getTreeClassHook() {
		return MatarchRootSelectAuth.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatarchInfo> selectedInfos) {
		return MatlisMerger.mergeWithMatarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
