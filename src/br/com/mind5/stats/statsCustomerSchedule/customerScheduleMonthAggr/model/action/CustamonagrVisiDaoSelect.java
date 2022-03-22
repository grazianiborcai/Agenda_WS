package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao.CustamonagrDaoSelect;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrVisiDaoSelect extends ActionVisitorTemplateStmt<CustamonagrInfo> {

	public CustamonagrVisiDaoSelect(DeciTreeOption<CustamonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CustamonagrInfo> buildStmtExecHook(List<DaoStmtExecOption<CustamonagrInfo>> stmtOptions) {
		return new CustamonagrDaoSelect(stmtOptions);
	}
}
