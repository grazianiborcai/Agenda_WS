package br.com.mind5.masterData.bankAccountType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankAccountType.dao.BankacypeDaoSelect;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankacypeVisiDaoSelect extends ActionVisitorTemplateStmt<BankacypeInfo> {

	public BankacypeVisiDaoSelect(DeciTreeOption<BankacypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankacypeInfo> buildStmtExecHook(List<DaoStmtExecOption<BankacypeInfo>> stmtOptions) {
		return new BankacypeDaoSelect(stmtOptions);
	}
}
