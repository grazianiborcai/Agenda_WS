package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class CusarchVisiMergeUsername extends ActionVisitorTemplateMerge<CusarchInfo, UsernameInfo> {
	
	public CusarchVisiMergeUsername(DeciTreeOption<CusarchInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CusarchInfo> baseInfos) {
		return UsernameCopier.copyFromCusarch(baseInfos);	
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return CusarchMerger.mergeWithUsername(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
