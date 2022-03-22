package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.decisionTree.CutefiloniveNodeAuthL1;

public final class CutefiloniveVisiNodeAuthL1 extends ActionVisitorTemplateAction<CutefiloniveInfo, CutefiloniveInfo> {

	public CutefiloniveVisiNodeAuthL1(DeciTreeOption<CutefiloniveInfo> option) {
		super(option, CutefiloniveInfo.class, CutefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefiloniveInfo>> getTreeClassHook() {
		return CutefiloniveNodeAuthL1.class;
	}
	
	
	
	@Override protected List<CutefiloniveInfo> toBaseClassHook(List<CutefiloniveInfo> baseInfos, List<CutefiloniveInfo> results) {
		return results;
	}
}
