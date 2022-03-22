package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao.CutefilonagrDaoSelect;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

public final class CutefilonagrVisiDaoSelect extends ActionVisitorTemplateStmt<CutefilonagrInfo> {

	public CutefilonagrVisiDaoSelect(DeciTreeOption<CutefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CutefilonagrInfo> buildStmtExecHook(List<DaoStmtExecOption<CutefilonagrInfo>> stmtOptions) {
		return new CutefilonagrDaoSelect(stmtOptions);
	}
}
