package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapCopier;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.decisionTree.RootCompnapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapMergeCompnap extends ActionVisitorTemplateMerge<StorapInfo, CompnapInfo> {
	
	public VisiStorapMergeCompnap(DeciTreeOption<StorapInfo> option) {
		super(option, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompnapInfo>> getTreeClassHook() {
		return RootCompnapSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> toActionClassHook(List<StorapInfo> baseInfos) {
		return CompnapCopier.copyFromStorap(baseInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<CompnapInfo> selectedInfos) {	
		return StorapMerger.mergeWithCompnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
