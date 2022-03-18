package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.decisionTree.StefiloniveRootSelect;

public final class StefiloniveVisiRootSelect extends ActionVisitorTemplateAction<StefiloniveInfo, StefiloniveInfo> {

	public StefiloniveVisiRootSelect(DeciTreeOption<StefiloniveInfo> option) {
		super(option, StefiloniveInfo.class, StefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefiloniveInfo>> getTreeClassHook() {
		return StefiloniveRootSelect.class;
	}
	
	
	
	@Override protected List<StefiloniveInfo> toBaseClassHook(List<StefiloniveInfo> baseInfos, List<StefiloniveInfo> results) {
		return results;
	}
}
