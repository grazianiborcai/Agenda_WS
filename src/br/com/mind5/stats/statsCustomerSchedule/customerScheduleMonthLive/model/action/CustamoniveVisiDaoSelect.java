package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.dao.CustamoniveDaoSelect;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamoniveVisiDaoSelect extends ActionVisitorTemplateStmt<CustamoniveInfo> {

	public CustamoniveVisiDaoSelect(DeciTreeOption<CustamoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CustamoniveInfo> buildStmtExecHook(List<DaoStmtExecOption<CustamoniveInfo>> stmtOptions) {
		return new CustamoniveDaoSelect(stmtOptions);
	}
}
