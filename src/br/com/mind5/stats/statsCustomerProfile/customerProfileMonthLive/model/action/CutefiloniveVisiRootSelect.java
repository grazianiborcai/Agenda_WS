package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.decisionTree.CutefiloniveRootSelect;

public final class CutefiloniveVisiRootSelect extends ActionVisitorTemplateAction<CutefiloniveInfo, CutefiloniveInfo> {

	public CutefiloniveVisiRootSelect(DeciTreeOption<CutefiloniveInfo> option) {
		super(option, CutefiloniveInfo.class, CutefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefiloniveInfo>> getTreeClassHook() {
		return CutefiloniveRootSelect.class;
	}
	
	
	
	@Override protected List<CutefiloniveInfo> toBaseClassHook(List<CutefiloniveInfo> baseInfos, List<CutefiloniveInfo> results) {
		return results;
	}
}
