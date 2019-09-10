package br.com.gda.file.fileUpload.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFilupDelete extends ActionLazyTemplate<FilupInfo, FilupInfo> {

	public LazyFilupDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FilupInfo> translateRecordInfosHook(List<FilupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FilupInfo> getInstanceOfActionHook(DeciTreeOption<FilupInfo> option) {
		return new StdFilupDelete(option);
	}
	
	
	
	@Override protected DeciResult<FilupInfo> translateResultHook(DeciResult<FilupInfo> result) {
		return result;
	}
}
