package br.com.mind5.masterData.timezone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.timezone.dao.DaoTimezoneSelect;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiTimezoneDaoSelect extends ActionVisitorTemplateStmt<TimezoneInfo> {

	public VisiTimezoneDaoSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<TimezoneInfo> buildStmtExecHook(List<DaoStmtExecOption<TimezoneInfo>> stmtOptions) {
		return new DaoTimezoneSelect(stmtOptions);
	}
}
