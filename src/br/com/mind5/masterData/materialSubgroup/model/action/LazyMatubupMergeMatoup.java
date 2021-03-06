package br.com.mind5.masterData.materialSubgroup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatubupMergeMatoup extends ActionLazyTemplate<MatubupInfo, MatubupInfo> {

	public LazyMatubupMergeMatoup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatubupInfo> translateRecordInfosHook(List<MatubupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatubupInfo> getInstanceOfActionHook(DeciTreeOption<MatubupInfo> option) {
		return new StdMatubupMergeMatoup(option);
	}
	
	
	
	@Override protected DeciResult<MatubupInfo> translateResultHook(DeciResult<MatubupInfo> result) {
		return result;
	}
}
