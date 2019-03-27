package br.com.gda.business.material.model.action;

import java.sql.Connection;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.decisionTree.RootMatextDeleteAll;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiMatDeleteMatext extends ActionVisitorTemplateAction<MatInfo, MatextInfo> {
	public VisiMatDeleteMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getActionHook(DeciTreeOption<MatextInfo> option) {
		return new RootMatextDeleteAll(option).toAction();
	}
}
