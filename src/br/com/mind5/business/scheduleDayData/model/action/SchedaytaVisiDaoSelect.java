package br.com.mind5.business.scheduleDayData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDayData.dao.SchedaytaDaoSelect;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaVisiDaoSelect extends ActionVisitorTemplateStmt<SchedaytaInfo> {

	public SchedaytaVisiDaoSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedaytaInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedaytaInfo>> stmtOptions) {
		return new SchedaytaDaoSelect(stmtOptions);
	}
}
