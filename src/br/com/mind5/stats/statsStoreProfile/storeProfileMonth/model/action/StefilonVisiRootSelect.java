package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree.StefilonRootSelect;

public final class StefilonVisiRootSelect extends ActionVisitorTemplateAction<StefilonInfo, StefilonInfo> {

	public StefilonVisiRootSelect(DeciTreeOption<StefilonInfo> option) {
		super(option, StefilonInfo.class, StefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonInfo>> getTreeClassHook() {
		return StefilonRootSelect.class;
	}
	
	
	
	@Override protected List<StefilonInfo> toBaseClassHook(List<StefilonInfo> baseInfos, List<StefilonInfo> results) {
		return results;
	}
}
