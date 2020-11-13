package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.dao.DaoStoprosSelect;
import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprosDaoSelect extends ActionVisitorTemplateStmt<StoprosInfo> {

	public VisiStoprosDaoSelect(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoprosInfo> buildStmtExecHook(List<DaoStmtExecOption<StoprosInfo>> stmtOptions) {
		return new DaoStoprosSelect(stmtOptions);
	}
}
