package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.decisionTree.RootCountroneSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonapMergeCountrone extends ActionVisitorTemplateMergeV2<PhonapInfo, CountroneInfo> {
	
	public VisiPhonapMergeCountrone(DeciTreeOption<PhonapInfo> option) {
		super(option, CountroneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountroneInfo>> getTreeClassHook() {
		return RootCountroneSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<CountroneInfo> selectedInfos) {	
		return PhonapMerger.mergeWithCountrone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
