package br.com.mind5.masterData.businessArea.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.businessArea.dao.DaoBusareaSelect;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBusareaDaoSelect extends ActionVisitorTemplateStmtV2<BusareaInfo>{

	public VisiBusareaDaoSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<BusareaInfo> buildStmtExecHook(List<DaoStmtExecOption<BusareaInfo>> stmtOptions) {
		return new DaoBusareaSelect(stmtOptions);
	}
}
