package br.com.mind5.business.storeText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorextMergeUsername extends ActionLazyTemplateV2<StorextInfo, StorextInfo> {
	
	public LazyStorextMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorextInfo> translateRecordInfosHook(List<StorextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorextInfo> getInstanceOfActionHook(DeciTreeOption<StorextInfo> option) {
		return new StdStorextMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<StorextInfo> translateResultHook(DeciResult<StorextInfo> result) {
		return result;
	}
}
