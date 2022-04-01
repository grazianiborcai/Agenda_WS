package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.dao.CusnapDaoInsert;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusnapVisiDaoInsert extends ActionVisitorTemplateStmt<CusnapInfo> {

	public CusnapVisiDaoInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CusnapInfo>> stmtOptions) {
		return new CusnapDaoInsert(stmtOptions);
	}
}
