package br.com.mind5.masterData.materialSubgroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialSubgroupSearch.dao.MatubuparchDaoSelect;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubuparchVisiDaoSelect extends ActionVisitorTemplateStmt<MatubuparchInfo> {

	public MatubuparchVisiDaoSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatubuparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatubuparchInfo>> stmtOptions) {
		return new MatubuparchDaoSelect(stmtOptions);
	}
}
