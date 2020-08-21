package br.com.mind5.masterData.materialSubgroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialSubgroupSearch.dao.DaoMatubuparchSelect;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatubuparchDaoSelect extends ActionVisitorTemplateStmtV2<MatubuparchInfo> {

	public VisiMatubuparchDaoSelect(DeciTreeOption<MatubuparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatubuparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatubuparchInfo>> stmtOptions) {
		return new DaoMatubuparchSelect(stmtOptions);
	}
}
