package br.com.mind5.business.customerList.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.info.CuslisMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCuslisMergeFimist extends ActionVisitorTemplateMerge<CuslisInfo, FimistInfo> {
	
	public VisiCuslisMergeFimist(DeciTreeOption<CuslisInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<CuslisInfo> recordInfos) {
		return FimistCopier.copyFromCuslis(recordInfos);	
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return CuslisMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
