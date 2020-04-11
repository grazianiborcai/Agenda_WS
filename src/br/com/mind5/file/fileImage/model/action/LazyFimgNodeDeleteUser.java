package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.NodeFimgDeleteUser;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgNodeDeleteUser extends ActionLazyTemplateV1<FimgInfo, FimgInfo> {

	public LazyFimgNodeDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgInfo> translateRecordInfosHook(List<FimgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FimgInfo> getInstanceOfActionHook(DeciTreeOption<FimgInfo> option) {
		return new NodeFimgDeleteUser(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgInfo> translateResultHook(DeciResult<FimgInfo> result) {
		return result;
	}
}
