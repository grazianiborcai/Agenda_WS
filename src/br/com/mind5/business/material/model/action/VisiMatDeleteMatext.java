package br.com.mind5.business.material.model.action;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextDeleteAll;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatDeleteMatext extends ActionVisitorTemplateAction<MatInfo, MatextInfo> {
	public VisiMatDeleteMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getActionHook(DeciTreeOption<MatextInfo> option) {
		return new RootMatextDeleteAll(option).toAction();
	}
}
