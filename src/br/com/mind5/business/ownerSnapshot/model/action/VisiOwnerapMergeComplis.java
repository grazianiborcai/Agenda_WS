package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisCopier;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.ComplisRootSelect;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerapMergeComplis extends ActionVisitorTemplateMerge<OwnerapInfo, ComplisInfo> {
	
	public VisiOwnerapMergeComplis(DeciTreeOption<OwnerapInfo> option) {
		super(option, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return ComplisRootSelect.class;
	}
	
	
	
	protected List<ComplisInfo> toActionClassHook(List<OwnerapInfo> baseInfos) {
		return ComplisCopier.copyFromOwnerap(baseInfos);	
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithComplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
