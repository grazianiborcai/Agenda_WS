package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.dao.AddressDaoDelete;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiDaoDelete extends ActionVisitorTemplateStmt<AddressInfo> {

	public AddressVisiDaoDelete(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<AddressInfo> buildStmtExecHook(List<DaoStmtExecOption<AddressInfo>> stmtOptions) {
		return new AddressDaoDelete(stmtOptions);
	}
}
