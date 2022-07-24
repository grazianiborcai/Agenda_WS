package br.com.mind5.masterData.businessAreaSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.businessAreaSearch.dao.BusarearchDaoSelect;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusarearchVisiDaoSelect extends ActionVisitorTemplateStmt<BusarearchInfo> {

	public BusarearchVisiDaoSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BusarearchInfo> buildStmtExecHook(List<DaoStmtExecOption<BusarearchInfo>> stmtOptions) {
		return new BusarearchDaoSelect(stmtOptions);
	}
}
