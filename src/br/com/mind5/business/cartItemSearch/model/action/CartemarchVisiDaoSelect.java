package br.com.mind5.business.cartItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.cartItemSearch.dao.CartemarchDaoSelect;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemarchVisiDaoSelect extends ActionVisitorTemplateStmt<CartemarchInfo> {

	public CartemarchVisiDaoSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CartemarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CartemarchInfo>> stmtOptions) {
		return new CartemarchDaoSelect(stmtOptions);
	}
}
