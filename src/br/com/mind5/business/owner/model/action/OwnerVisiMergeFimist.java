package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.FimistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiMergeFimist extends ActionVisitorTemplateMerge<OwnerInfo, FimistInfo> {
	
	public OwnerVisiMergeFimist(DeciTreeOption<OwnerInfo> option) {
		super(option, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return FimistRootSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<OwnerInfo> baseInfos) {
		return FimistCopier.copyFromOwner(baseInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return OwnerMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
