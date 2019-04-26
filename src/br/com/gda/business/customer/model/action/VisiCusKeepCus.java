package br.com.gda.business.customer.model.action;

import java.sql.Connection;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusKeeper;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateKeep;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusKeepCus extends ActionVisitorTemplateKeep<CusInfo, CusInfo> {

	public VisiCusKeepCus(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusInfo> getActionHook(DeciTreeOption<CusInfo> option) {
		ActionStd<CusInfo> actionSelect = new StdCusEnforceKey(option);
		actionSelect.addPostAction(new LazyCusRootSelect(option.conn, option.schemaName));
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CusInfo>> getKeeperClassHook() {
		return CusKeeper.class;
	}
}
