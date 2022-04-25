package br.com.mind5.business.employeeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.dao.EmplutmapDaoSelect;
import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmapVisiDaoSelect extends ActionVisitorTemplateStmt<EmplutmapInfo> {

	public EmplutmapVisiDaoSelect(DeciTreeOption<EmplutmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplutmapInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplutmapInfo>> stmtOptions) {
		return new EmplutmapDaoSelect(stmtOptions);
	}
}
