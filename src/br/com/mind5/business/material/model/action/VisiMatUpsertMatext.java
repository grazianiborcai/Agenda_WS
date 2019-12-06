package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextUpsertdel;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatUpsertMatext extends ActionVisitorTemplateAction<MatInfo, MatextInfo> {
	public VisiMatUpsertMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getActionHook(DeciTreeOption<MatextInfo> option) {
		return new RootMatextUpsertdel(option).toAction();
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatInfo> baseInfos) {
		return MatextCopier.copyFromMat(baseInfos);
	}
	
	
	
	@Override protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatextInfo> results) {
		return MatMerger.mergeWithMatext(results, baseInfos);
	}
}
