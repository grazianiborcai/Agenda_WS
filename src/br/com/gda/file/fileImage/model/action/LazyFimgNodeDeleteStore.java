package br.com.gda.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.NodeFimgDeleteStore;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFimgNodeDeleteStore extends ActionLazyTemplate<FimgInfo, FimgInfo> {

	public LazyFimgNodeDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgInfo> translateRecordInfosHook(List<FimgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgInfo> getInstanceOfActionHook(DeciTreeOption<FimgInfo> option) {
		return new NodeFimgDeleteStore(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgInfo> translateResultHook(DeciResult<FimgInfo> result) {
		return result;
	}
}
