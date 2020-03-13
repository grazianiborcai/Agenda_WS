package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.decisionTree.RootMatsnapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatInsertMatsnap extends ActionVisitorTemplateAction<MatInfo, MatsnapInfo> {

	public VisiMatInsertMatsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class, MatsnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatsnapInfo> getActionHook(DeciTreeOption<MatsnapInfo> option) {
		return new RootMatsnapInsert(option).toAction();
	}
	
	
	
	protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatsnapInfo> results) {
		return MatMerger.mergeWithMatsnap(baseInfos, results);
	}
}
