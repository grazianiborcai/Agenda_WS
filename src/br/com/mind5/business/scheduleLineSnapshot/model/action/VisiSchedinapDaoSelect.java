package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.DaoSchedinapSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapDaoSelect extends ActionVisitorTemplateStmt<SchedinapInfo> {

	public VisiSchedinapDaoSelect(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedinapInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedinapInfo>> stmtOptions) {
		return new DaoSchedinapSelect(stmtOptions);
	}
}
