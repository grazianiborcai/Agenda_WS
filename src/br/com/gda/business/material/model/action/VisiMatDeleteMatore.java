package br.com.gda.business.material.model.action;

import java.sql.Connection;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.RootMatoreDeleteByMat;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiMatDeleteMatore extends ActionVisitorTemplateAction<MatInfo, MatoreInfo> {
	public VisiMatDeleteMatore(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> getActionHook(DeciTreeOption<MatoreInfo> option) {
		return new RootMatoreDeleteByMat(option).toAction();
	}
}
