package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapMerger;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.business.materialTextSnapshot.model.decisionTree.RootMatextsnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiMatsnapInsertMatextsnap extends ActionVisitorTemplateAction<MatsnapInfo, MatextsnapInfo> {

	public VisiMatsnapInsertMatextsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatsnapInfo.class, MatextsnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextsnapInfo> getActionHook(DeciTreeOption<MatextsnapInfo> option) {
		return new RootMatextsnapInsert(option).toAction();
	}
	
	
	
	protected List<MatsnapInfo> toBaseClassHook(List<MatsnapInfo> baseInfos, List<MatextsnapInfo> results) {
		return MatsnapMerger.mergeWithMatextsnap(results, baseInfos);
	}
}
