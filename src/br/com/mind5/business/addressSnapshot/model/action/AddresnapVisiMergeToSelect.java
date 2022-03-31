package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiMergeToSelect extends ActionVisitorTemplateMerge<AddresnapInfo, AddresnapInfo> {
	
	public AddresnapVisiMergeToSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<AddresnapInfo>> getVisitorClassHook() {
		return AddresnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return AddresnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
