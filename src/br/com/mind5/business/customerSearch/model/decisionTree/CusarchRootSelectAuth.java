package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiRootSelect;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiMergeSytotauh;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusarchRootSelectAuth extends DeciTreeTemplateRead<CusarchInfo> {
	
	public CusarchRootSelectAuth(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> mergeSytotauh = new ActionStdCommom<CusarchInfo>(option, CusarchVisiMergeSytotauh.class);
		ActionLazy<CusarchInfo> select = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiRootSelect.class);
		
		mergeSytotauh.addPostAction(select);
		
		actions.add(mergeSytotauh);
		return actions;
	}
}
