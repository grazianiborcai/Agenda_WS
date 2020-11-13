package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.dao.DaoCrecardInsert;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class VisiCrecardDaoInsert extends ActionVisitorTemplateStmt<CrecardInfo> {

	public VisiCrecardDaoInsert(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CrecardInfo> buildStmtExecHook(List<DaoStmtExecOption<CrecardInfo>> stmtOptions) {
		return new DaoCrecardInsert(stmtOptions);
	}
}
