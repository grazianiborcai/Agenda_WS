package br.com.mind5.masterData.bankAccountTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankAccountTypeSearch.dao.BankacyperchDaoSelect;
import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankacyperchVisiDaoSelect extends ActionVisitorTemplateStmt<BankacyperchInfo> {

	public BankacyperchVisiDaoSelect(DeciTreeOption<BankacyperchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankacyperchInfo> buildStmtExecHook(List<DaoStmtExecOption<BankacyperchInfo>> stmtOptions) {
		return new BankacyperchDaoSelect(stmtOptions);
	}
}
