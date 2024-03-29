package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.decisionTree.CountroneRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergeCountrone extends ActionVisitorTemplateMerge<PhoneInfo, CountroneInfo> {
	
	public PhoneVisiMergeCountrone(DeciTreeOption<PhoneInfo> option) {
		super(option, CountroneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountroneInfo>> getTreeClassHook() {
		return CountroneRootSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<CountroneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithCountrone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
