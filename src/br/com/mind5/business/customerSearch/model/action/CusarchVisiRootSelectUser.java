package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.CusarchRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiRootSelectUser extends ActionVisitorTemplateAction<CusarchInfo, CusarchInfo> {

	public CusarchVisiRootSelectUser(DeciTreeOption<CusarchInfo> option) {
		super(option, CusarchInfo.class, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return CusarchRootSelectUser.class;
	}
	
	
	
	@Override protected List<CusarchInfo> toBaseClassHook(List<CusarchInfo> baseInfos, List<CusarchInfo> results) {
		return results;
	}
}
