package br.com.mind5.discount.discountCouponItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountCouponItem.model.decisionTree.RootDisoupemInsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisoupemRootInsert extends ActionLazyTemplate<DisoupemInfo, DisoupemInfo> {
	
	public LazyDisoupemRootInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisoupemInfo> translateRecordInfosHook(List<DisoupemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisoupemInfo> getInstanceOfActionHook(DeciTreeOption<DisoupemInfo> option) {
		return new RootDisoupemInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<DisoupemInfo> translateResultHook(DeciResult<DisoupemInfo> result) {
		return result;
	}
}
