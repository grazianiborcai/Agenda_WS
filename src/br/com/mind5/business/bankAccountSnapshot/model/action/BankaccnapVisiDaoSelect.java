package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.dao.BankaccnapDaoSelect;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiDaoSelect extends ActionVisitorTemplateStmt<BankaccnapInfo> {

	public BankaccnapVisiDaoSelect(DeciTreeOption<BankaccnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankaccnapInfo> buildStmtExecHook(List<DaoStmtExecOption<BankaccnapInfo>> stmtOptions) {
		return new BankaccnapDaoSelect(stmtOptions);
	}
}
