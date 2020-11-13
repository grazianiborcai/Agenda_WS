package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialSubgroup.dao.DaoMatubupSelect;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatubupDaoSelect extends ActionVisitorTemplateStmt<MatubupInfo> {

	public VisiMatubupDaoSelect(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatubupInfo> buildStmtExecHook(List<DaoStmtExecOption<MatubupInfo>> stmtOptions) {
		return new DaoMatubupSelect(stmtOptions);
	}
}
