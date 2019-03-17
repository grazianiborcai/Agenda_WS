package br.com.gda.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.info.MatmovMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiMatmovMergeUsername extends ActionVisitorTemplateMerge<MatmovInfo, UsernameInfo> {
	
	public VisiMatmovMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<MatmovInfo> recordInfos) {
		return UsernameCopier.copyFromMatmov(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatmovInfo>> getMergerClassHook() {
		return MatmovMerger.class;
	}
}
