package br.com.mind5.masterData.currency.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.currency.dao.CurrencyDaoSelect;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrencyVisiDaoSelect extends ActionVisitorTemplateStmt<CurrencyInfo> {

	public CurrencyVisiDaoSelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CurrencyInfo> buildStmtExecHook(List<DaoStmtExecOption<CurrencyInfo>> stmtOptions) {
		return new CurrencyDaoSelect(stmtOptions);
	}
}
