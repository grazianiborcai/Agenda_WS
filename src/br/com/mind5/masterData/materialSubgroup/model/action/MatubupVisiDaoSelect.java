package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialSubgroup.dao.MatubupDaoSelect;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupVisiDaoSelect extends ActionVisitorTemplateStmt<MatubupInfo> {

	public MatubupVisiDaoSelect(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatubupInfo> buildStmtExecHook(List<DaoStmtExecOption<MatubupInfo>> stmtOptions) {
		return new MatubupDaoSelect(stmtOptions);
	}
}
