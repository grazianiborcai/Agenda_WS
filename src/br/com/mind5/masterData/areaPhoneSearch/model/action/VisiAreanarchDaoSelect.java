package br.com.mind5.masterData.areaPhoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.areaPhoneSearch.dao.DaoAreanarchSelect;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAreanarchDaoSelect extends ActionVisitorTemplateStmt<AreanarchInfo> {

	public VisiAreanarchDaoSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AreanarchInfo> buildStmtExecHook(List<DaoStmtExecOption<AreanarchInfo>> stmtOptions) {
		return new DaoAreanarchSelect(stmtOptions);
	}
}
