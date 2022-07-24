package br.com.mind5.masterData.businessArea.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.businessArea.dao.BusareaDaoSelect;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusareaVisiDaoSelect extends ActionVisitorTemplateStmt<BusareaInfo> {

	public BusareaVisiDaoSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BusareaInfo> buildStmtExecHook(List<DaoStmtExecOption<BusareaInfo>> stmtOptions) {
		return new BusareaDaoSelect(stmtOptions);
	}
}
