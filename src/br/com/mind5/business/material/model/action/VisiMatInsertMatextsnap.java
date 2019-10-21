package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.decisionTree.RootMatextsnapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatInsertMatextsnap extends ActionVisitorTemplateAction<MatInfo, MatextsnapInfo> {

	public VisiMatInsertMatextsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatextsnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextsnapInfo> getActionHook(DeciTreeOption<MatextsnapInfo> option) {
		return new RootMatextsnapInsert(option).toAction();
	}
	
	
	
	protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatextsnapInfo> results) {
		return baseInfos;
	}
}
