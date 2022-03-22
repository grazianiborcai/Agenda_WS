package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree.CutefilonRootSelect;

public final class CutefilonVisiRootSelect extends ActionVisitorTemplateAction<CutefilonInfo, CutefilonInfo> {

	public CutefilonVisiRootSelect(DeciTreeOption<CutefilonInfo> option) {
		super(option, CutefilonInfo.class, CutefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonInfo>> getTreeClassHook() {
		return CutefilonRootSelect.class;
	}
	
	
	
	@Override protected List<CutefilonInfo> toBaseClassHook(List<CutefilonInfo> baseInfos, List<CutefilonInfo> results) {
		return results;
	}
}
