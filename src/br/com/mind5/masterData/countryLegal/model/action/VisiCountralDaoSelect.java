package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryLegal.dao.DaoCountralSelect;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountralDaoSelect extends ActionVisitorTemplateStmt<CountralInfo> {

	public VisiCountralDaoSelect(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountralInfo> buildStmtExecHook(List<DaoStmtExecOption<CountralInfo>> stmtOptions) {
		return new DaoCountralSelect(stmtOptions);
	}
}
