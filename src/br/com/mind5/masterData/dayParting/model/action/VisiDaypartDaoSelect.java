package br.com.mind5.masterData.dayParting.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.dayParting.dao.DaoDaypartSelect;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDaypartDaoSelect extends ActionVisitorTemplateStmt<DaypartInfo> {

	public VisiDaypartDaoSelect(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DaypartInfo> buildStmtExecHook(List<DaoStmtExecOption<DaypartInfo>> stmtOptions) {
		return new DaoDaypartSelect(stmtOptions);
	}
}
