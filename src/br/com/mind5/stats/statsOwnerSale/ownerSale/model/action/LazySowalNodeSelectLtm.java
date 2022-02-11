package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree.NodeSowalSelectLtm;

public final class LazySowalNodeSelectLtm extends ActionLazyTemplate<SowalInfo, SowalInfo> {

	public LazySowalNodeSelectLtm(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowalInfo> translateRecordInfosHook(List<SowalInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowalInfo> getInstanceOfActionHook(DeciTreeOption<SowalInfo> option) {
		return new NodeSowalSelectLtm(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowalInfo> translateResultHook(DeciResult<SowalInfo> result) {
		return result;
	}
}
