package br.com.mind5.business.addressDefault.model.action;

import java.util.List;

import br.com.mind5.business.addressDefault.dao.AddaultDaoSelect;
import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultVisiDaoSelect extends ActionVisitorTemplateStmt<AddaultInfo> {

	public AddaultVisiDaoSelect(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddaultInfo> buildStmtExecHook(List<DaoStmtExecOption<AddaultInfo>> stmtOptions) {
		return new AddaultDaoSelect(stmtOptions);
	}
}
