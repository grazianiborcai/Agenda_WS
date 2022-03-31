package br.com.mind5.business.scheduleReserve.model.action;

import java.util.List;

import br.com.mind5.business.scheduleReserve.dao.SchederveDaoSelect;
import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchederveVisiDaoSelect extends ActionVisitorTemplateStmt<SchederveInfo> {

	public SchederveVisiDaoSelect(DeciTreeOption<SchederveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchederveInfo> buildStmtExecHook(List<DaoStmtExecOption<SchederveInfo>> stmtOptions) {
		return new SchederveDaoSelect(stmtOptions);
	}
}
