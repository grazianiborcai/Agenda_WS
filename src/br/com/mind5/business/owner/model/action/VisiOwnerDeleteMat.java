package br.com.mind5.business.owner.model.action;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatDeleteAll_;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteMat extends ActionVisitorTemplateAction<OwnerInfo, MatInfo> {
	public VisiOwnerDeleteMat(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, MatInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatInfo> getActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatDeleteAll_(option).toAction();
	}
}
