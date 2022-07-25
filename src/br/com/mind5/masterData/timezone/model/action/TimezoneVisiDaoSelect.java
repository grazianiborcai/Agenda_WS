package br.com.mind5.masterData.timezone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.timezone.dao.TimezoneDaoSelect;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezoneVisiDaoSelect extends ActionVisitorTemplateStmt<TimezoneInfo> {

	public TimezoneVisiDaoSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<TimezoneInfo> buildStmtExecHook(List<DaoStmtExecOption<TimezoneInfo>> stmtOptions) {
		return new TimezoneDaoSelect(stmtOptions);
	}
}
