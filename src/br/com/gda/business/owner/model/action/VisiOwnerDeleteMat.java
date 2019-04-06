package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatDeleteAll;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteMat extends ActionVisitorTemplateAction<OwnerInfo, MatInfo> {
	public VisiOwnerDeleteMat(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, MatInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatInfo> getActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatDeleteAll(option).toAction();
	}
}
