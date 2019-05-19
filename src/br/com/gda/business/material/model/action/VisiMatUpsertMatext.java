package br.com.gda.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.decisionTree.RootMatextUpsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiMatUpsertMatext extends ActionVisitorTemplateAction<MatInfo, MatextInfo> {
	public VisiMatUpsertMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getActionHook(DeciTreeOption<MatextInfo> option) {
		return new RootMatextUpsert(option).toAction();
	}
	
	
	
	@Override protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatextInfo> results) {
		return MatMerger.mergeWithMatext(results, baseInfos);
	}
}
