package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.decisionTree.CusnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiCusnapInsert extends ActionVisitorTemplateAction<CusInfo, CusnapInfo> {

	public CusVisiCusnapInsert(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, CusnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusnapInfo>> getTreeClassHook() {
		return CusnapRootInsert.class;
	}
	
	
	
	protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<CusnapInfo> results) {
		return CusMerger.mergeWithCusnap(baseInfos, results);
	}
}
