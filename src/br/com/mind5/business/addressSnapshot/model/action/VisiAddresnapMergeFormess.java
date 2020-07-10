package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.decisionTree.RootFormessSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnapMergeFormess extends ActionVisitorTemplateMergeV2<AddresnapInfo, FormessInfo> {
	
	public VisiAddresnapMergeFormess(DeciTreeOption<AddresnapInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return RootFormessSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<FormessInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithFormess(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
