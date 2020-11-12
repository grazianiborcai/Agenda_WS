package br.com.mind5.business.scheduleRange.model.action;

import java.util.List;

import br.com.mind5.business.scheduleRange.dao.DaoSchedageSelect;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedageDaoSelect extends ActionVisitorTemplateStmtV2<SchedageInfo> {

	public VisiSchedageDaoSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedageInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedageInfo>> stmtOptions) {
		return new DaoSchedageSelect(stmtOptions);
	}
}
