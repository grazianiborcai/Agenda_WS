package br.com.mind5.business.calendarMonthSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonthSearch.dao.CalontharchDaoSelect;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiDaoSelect extends ActionVisitorTemplateStmt<CalontharchInfo> {

	public CalontharchVisiDaoSelect(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalontharchInfo> buildStmtExecHook(List<DaoStmtExecOption<CalontharchInfo>> stmtOptions) {
		return new CalontharchDaoSelect(stmtOptions);
	}
}
