package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.FimistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiMergeFimist extends ActionVisitorTemplateMerge<CusInfo, FimistInfo> {
	
	public CusVisiMergeFimist(DeciTreeOption<CusInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return FimistRootSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return FimistCopier.copyFromCus(baseInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return CusMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
