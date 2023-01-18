package br.com.mind5.masterData.bank.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.bank.dao.BankDaoSelect;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankVisiDaoSelect extends ActionVisitorTemplateStmt<BankInfo> {

	public BankVisiDaoSelect(DeciTreeOption<BankInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankInfo> buildStmtExecHook(List<DaoStmtExecOption<BankInfo>> stmtOptions) {
		return new BankDaoSelect(stmtOptions);
	}
}
