package br.com.mind5.business.orderStatusChange.model.action;

import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.decisionTree.OrdugeNodePartnerL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdugeVisiNodePartnerL1 extends ActionVisitorTemplateAction<OrdugeInfo, OrdugeInfo> {

	public OrdugeVisiNodePartnerL1(DeciTreeOption<OrdugeInfo> option) {
		super(option, OrdugeInfo.class, OrdugeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdugeInfo>> getTreeClassHook() {
		return OrdugeNodePartnerL1.class;
	}
	
	
	
	@Override protected List<OrdugeInfo> toBaseClassHook(List<OrdugeInfo> baseInfos, List<OrdugeInfo> results) {
		return results;
	}
}
