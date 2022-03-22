package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao.CustamonagrDaoInsert;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrVisiDaoInsert extends ActionVisitorTemplateStmt<CustamonagrInfo> {

	public CustamonagrVisiDaoInsert(DeciTreeOption<CustamonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CustamonagrInfo> buildStmtExecHook(List<DaoStmtExecOption<CustamonagrInfo>> stmtOptions) {
		return new CustamonagrDaoInsert(stmtOptions);
	}
}
