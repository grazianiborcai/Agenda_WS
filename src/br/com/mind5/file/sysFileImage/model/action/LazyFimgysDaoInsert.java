package br.com.mind5.file.sysFileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgysDaoInsert extends ActionLazyTemplate<FimgysInfo, FimgysInfo> {
	
	public LazyFimgysDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgysInfo> translateRecordInfosHook(List<FimgysInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgysInfo> getInstanceOfActionHook(DeciTreeOption<FimgysInfo> option) {
		return new StdFimgysDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<FimgysInfo> translateResultHook(DeciResult<FimgysInfo> result) {
		return result;
	}
}
