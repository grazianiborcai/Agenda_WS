package br.com.mind5.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.model.decisionTree.RootMatorapInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreInsertMatorap extends ActionVisitorTemplateAction<MatoreInfo, MatorapInfo> {

	public VisiMatoreInsertMatorap(Connection conn, String schemaName) {
		super(conn, schemaName, MatoreInfo.class, MatorapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MatorapInfo> getActionHook(DeciTreeOption<MatorapInfo> option) {
		return new RootMatorapInsert(option).toAction();
	}
	
	
	
	protected List<MatoreInfo> toBaseClassHook(List<MatoreInfo> baseInfos, List<MatorapInfo> results) {
		return MatoreMerger.mergeWithMatorap(baseInfos, results);
	}
}
