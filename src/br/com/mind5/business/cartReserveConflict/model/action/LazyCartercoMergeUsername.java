package br.com.mind5.business.cartReserveConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartercoMergeUsername extends ActionLazyTemplate<CartercoInfo, CartercoInfo> {

	public LazyCartercoMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartercoInfo> translateRecordInfosHook(List<CartercoInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartercoInfo> getInstanceOfActionHook(DeciTreeOption<CartercoInfo> option) {
		return new StdCartercoMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<CartercoInfo> translateResultHook(DeciResult<CartercoInfo> result) {
		return result;
	}
}
