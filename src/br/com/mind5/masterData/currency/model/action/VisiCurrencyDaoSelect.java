package br.com.mind5.masterData.currency.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.currency.dao.DaoCurrencySelect;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCurrencyDaoSelect extends ActionVisitorTemplateStmt<CurrencyInfo> {

	public VisiCurrencyDaoSelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CurrencyInfo> buildStmtExecHook(List<DaoStmtExecOption<CurrencyInfo>> stmtOptions) {
		return new DaoCurrencySelect(stmtOptions);
	}
}
