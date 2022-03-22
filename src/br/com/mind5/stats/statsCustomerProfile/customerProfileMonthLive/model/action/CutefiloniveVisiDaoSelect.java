package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.dao.CutefiloniveDaoSelect;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveVisiDaoSelect extends ActionVisitorTemplateStmt<CutefiloniveInfo> {

	public CutefiloniveVisiDaoSelect(DeciTreeOption<CutefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CutefiloniveInfo> buildStmtExecHook(List<DaoStmtExecOption<CutefiloniveInfo>> stmtOptions) {
		return new CutefiloniveDaoSelect(stmtOptions);
	}
}
