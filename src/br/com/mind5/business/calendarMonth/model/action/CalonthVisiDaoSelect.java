package br.com.mind5.business.calendarMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.dao.CalonthDaoSelect;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthVisiDaoSelect extends ActionVisitorTemplateStmt<CalonthInfo> {

	public CalonthVisiDaoSelect(DeciTreeOption<CalonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalonthInfo> buildStmtExecHook(List<DaoStmtExecOption<CalonthInfo>> stmtOptions) {
		return new CalonthDaoSelect(stmtOptions);
	}
}
