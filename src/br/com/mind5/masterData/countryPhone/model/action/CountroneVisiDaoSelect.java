package br.com.mind5.masterData.countryPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countryPhone.dao.CountroneDaoSelect;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountroneVisiDaoSelect extends ActionVisitorTemplateStmt<CountroneInfo> {

	public CountroneVisiDaoSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CountroneInfo> buildStmtExecHook(List<DaoStmtExecOption<CountroneInfo>> stmtOptions) {
		return new CountroneDaoSelect(stmtOptions);
	}
}
