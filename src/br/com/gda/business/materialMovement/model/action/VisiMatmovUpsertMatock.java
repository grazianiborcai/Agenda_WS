package br.com.gda.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialStock.info.MatockCopier;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.decisionTree.RootMatockUpsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiMatmovUpsertMatock extends ActionVisitorTemplateAction<MatmovInfo, MatockInfo> {
	public VisiMatmovUpsertMatock(Connection conn, String schemaName) {
		super(conn, schemaName, MatmovInfo.class, MatockInfo.class);
	}
	
	
	
	@Override protected List<MatockInfo> toActionClassHook(List<MatmovInfo> recordInfos) {
		return MatockCopier.copyFromMatmov(recordInfos);
	}
	
	
	
	@Override protected ActionStd<MatockInfo> getActionHook(DeciTreeOption<MatockInfo> option) {
		return new RootMatockUpsert(option).toAction();
	}
}
