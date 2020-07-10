package br.com.mind5.masterData.timezone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.timezone.dao.DaoTimezoneSelect;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiTimezoneDaoSelect extends ActionVisitorTemplateStmtV2<TimezoneInfo> {

	public VisiTimezoneDaoSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<TimezoneInfo> buildStmtExecHook(List<DaoStmtExecOption<TimezoneInfo>> stmtOptions) {
		return new DaoTimezoneSelect(stmtOptions);
	}
}
