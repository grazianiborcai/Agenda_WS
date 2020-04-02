package br.com.mind5.business.material.model.action;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreDeleteByMat;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatDeleteMatore extends ActionVisitorTemplateAction<MatInfo, MatoreInfo> {
	public VisiMatDeleteMatore(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatoreInfo> getActionHook(DeciTreeOption<MatoreInfo> option) {
		return new RootMatoreDeleteByMat(option).toAction();
	}
}
