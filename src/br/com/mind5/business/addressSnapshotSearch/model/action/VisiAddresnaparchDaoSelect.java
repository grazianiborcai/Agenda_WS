package br.com.mind5.business.addressSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.dao.DaoAddresnaparchSelect;
import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnaparchDaoSelect extends ActionVisitorTemplateStmt<AddresnaparchInfo> {

	public VisiAddresnaparchDaoSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddresnaparchInfo> buildStmtExecHook(List<DaoStmtExecOption<AddresnaparchInfo>> stmtOptions) {
		return new DaoAddresnaparchSelect(stmtOptions);
	}
}
