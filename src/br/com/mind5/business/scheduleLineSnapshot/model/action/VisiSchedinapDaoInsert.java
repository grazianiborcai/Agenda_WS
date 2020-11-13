package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.DaoSchedinapInsert;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapDaoInsert extends ActionVisitorTemplateStmt<SchedinapInfo> {

	public VisiSchedinapDaoInsert(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedinapInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedinapInfo>> stmtOptions) {
		return new DaoSchedinapInsert(stmtOptions);
	}
}
