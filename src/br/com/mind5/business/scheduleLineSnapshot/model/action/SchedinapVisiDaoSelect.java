package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDaoSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedinapVisiDaoSelect extends ActionVisitorTemplateStmt<SchedinapInfo> {

	public SchedinapVisiDaoSelect(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedinapInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedinapInfo>> stmtOptions) {
		return new SchedinapDaoSelect(stmtOptions);
	}
}
