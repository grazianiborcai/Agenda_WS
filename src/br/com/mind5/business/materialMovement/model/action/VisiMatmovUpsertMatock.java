package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.business.materialStock.info.MatockCopier;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.decisionTree.RootMatockUpsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovUpsertMatock extends ActionVisitorTemplateActionV1<MatmovInfo, MatockInfo> {
	public VisiMatmovUpsertMatock(Connection conn, String schemaName) {
		super(conn, schemaName, MatmovInfo.class, MatockInfo.class);
	}
	
	
	
	@Override protected List<MatockInfo> toActionClassHook(List<MatmovInfo> recordInfos) {
		return MatockCopier.copyFromMatmov(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<MatockInfo> getActionHook(DeciTreeOption<MatockInfo> option) {
		return new RootMatockUpsert(option).toAction();
	}
	
	
	
	@Override protected List<MatmovInfo> toBaseClassHook(List<MatmovInfo> baseInfos, List<MatockInfo> results) {
		return MatmovMerger.mergeWithMatock(results, baseInfos);
	}
}
