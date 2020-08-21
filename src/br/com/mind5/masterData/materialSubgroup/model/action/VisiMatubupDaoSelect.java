package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialSubgroup.dao.DaoMatubupSelect;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatubupDaoSelect extends ActionVisitorTemplateStmtV2<MatubupInfo> {

	public VisiMatubupDaoSelect(DeciTreeOption<MatubupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatubupInfo> buildStmtExecHook(List<DaoStmtExecOption<MatubupInfo>> stmtOptions) {
		return new DaoMatubupSelect(stmtOptions);
	}
}
