package br.com.mind5.business.orderSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderSnapshot.dao.DaoOrdnapInsert;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdnapDaoInsert extends ActionVisitorTemplateStmt<OrdnapInfo> {

	public VisiOrdnapDaoInsert(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdnapInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdnapInfo>> stmtOptions) {
		return new DaoOrdnapInsert(stmtOptions);
	}
}
