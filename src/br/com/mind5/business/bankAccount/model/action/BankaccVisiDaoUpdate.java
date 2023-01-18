package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.dao.BankaccDaoUpdate;
import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiDaoUpdate extends ActionVisitorTemplateStmt<BankaccInfo> {

	public BankaccVisiDaoUpdate(DeciTreeOption<BankaccInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankaccInfo> buildStmtExecHook(List<DaoStmtExecOption<BankaccInfo>> stmtOptions) {
		return new BankaccDaoUpdate(stmtOptions);
	}
}
