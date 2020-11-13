package br.com.mind5.masterData.businessAreaSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.businessAreaSearch.dao.DaoBusarearchSelect;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBusarearchDaoSelect extends ActionVisitorTemplateStmt<BusarearchInfo> {

	public VisiBusarearchDaoSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<BusarearchInfo> buildStmtExecHook(List<DaoStmtExecOption<BusarearchInfo>> stmtOptions) {
		return new DaoBusarearchSelect(stmtOptions);
	}
}
