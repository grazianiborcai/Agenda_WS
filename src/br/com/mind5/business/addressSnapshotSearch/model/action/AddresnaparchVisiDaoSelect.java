package br.com.mind5.business.addressSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.dao.AddresnaparchDaoSelect;
import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnaparchVisiDaoSelect extends ActionVisitorTemplateStmt<AddresnaparchInfo> {

	public AddresnaparchVisiDaoSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddresnaparchInfo> buildStmtExecHook(List<DaoStmtExecOption<AddresnaparchInfo>> stmtOptions) {
		return new AddresnaparchDaoSelect(stmtOptions);
	}
}
