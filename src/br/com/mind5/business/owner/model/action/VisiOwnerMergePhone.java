package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerMergePhone extends ActionVisitorTemplateMerge<OwnerInfo, PhoneInfo> {
	
	public VisiOwnerMergePhone(DeciTreeOption<OwnerInfo> option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootSearch.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<OwnerInfo> baseInfos) {
		return PhoneCopier.copyFromOwner(baseInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return OwnerMerger.mergeWithPhone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
