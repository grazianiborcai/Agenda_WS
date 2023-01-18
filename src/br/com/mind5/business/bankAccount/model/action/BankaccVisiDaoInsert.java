package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.dao.BankaccDaoInsert;
import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiDaoInsert extends ActionVisitorTemplateStmt<BankaccInfo> {

	public BankaccVisiDaoInsert(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankaccInfo> buildStmtExecHook(List<DaoStmtExecOption<BankaccInfo>> stmtOptions) {
		return new BankaccDaoInsert(stmtOptions);
	}
}
