package br.com.mind5.masterData.currencySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.currencySearch.dao.CurrarshDaoSelect;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrarshVisiDaoSelect extends ActionVisitorTemplateStmt<CurrarshInfo> {

	public CurrarshVisiDaoSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CurrarshInfo> buildStmtExecHook(List<DaoStmtExecOption<CurrarshInfo>> stmtOptions) {
		return new CurrarshDaoSelect(stmtOptions);
	}
}
