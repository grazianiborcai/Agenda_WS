package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.dao.DaoAddresnapInsert;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnapDaoInsert extends ActionVisitorTemplateStmt<AddresnapInfo> {

	public VisiAddresnapDaoInsert(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddresnapInfo> buildStmtExecHook(List<DaoStmtExecOption<AddresnapInfo>> stmtOptions) {
		return new DaoAddresnapInsert(stmtOptions);
	}
}
