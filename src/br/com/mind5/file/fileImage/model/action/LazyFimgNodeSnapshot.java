package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.NodeFimgSnapshot;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgNodeSnapshot extends ActionLazyTemplate<FimgInfo, FimgInfo> {

	public LazyFimgNodeSnapshot(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgInfo> translateRecordInfosHook(List<FimgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgInfo> getInstanceOfActionHook(DeciTreeOption<FimgInfo> option) {
		return new NodeFimgSnapshot(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgInfo> translateResultHook(DeciResult<FimgInfo> result) {
		return result;
	}
}
