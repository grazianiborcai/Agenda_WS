package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.decisionTree.RootCusnapInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusInsertCusnap extends ActionVisitorTemplateAction<CusInfo, CusnapInfo> {

	public VisiCusInsertCusnap(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, CusnapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CusnapInfo> getActionHook(DeciTreeOption<CusnapInfo> option) {
		return new RootCusnapInsert(option).toAction();
	}
	
	
	
	protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<CusnapInfo> results) {
		return CusMerger.mergeWithCusnap(results, baseInfos);
	}
}
