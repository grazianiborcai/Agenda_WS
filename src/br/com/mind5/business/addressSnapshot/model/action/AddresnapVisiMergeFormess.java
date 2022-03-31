package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.decisionTree.RootFormessSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiMergeFormess extends ActionVisitorTemplateMerge<AddresnapInfo, FormessInfo> {
	
	public AddresnapVisiMergeFormess(DeciTreeOption<AddresnapInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return RootFormessSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<FormessInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithFormess(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
