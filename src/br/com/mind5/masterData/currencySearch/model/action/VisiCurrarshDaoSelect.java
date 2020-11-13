package br.com.mind5.masterData.currencySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.currencySearch.dao.DaoCurrarshSelect;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCurrarshDaoSelect extends ActionVisitorTemplateStmt<CurrarshInfo> {

	public VisiCurrarshDaoSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CurrarshInfo> buildStmtExecHook(List<DaoStmtExecOption<CurrarshInfo>> stmtOptions) {
		return new DaoCurrarshSelect(stmtOptions);
	}
}
