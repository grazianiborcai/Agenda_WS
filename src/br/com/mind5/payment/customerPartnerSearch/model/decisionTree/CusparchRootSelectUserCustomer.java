package br.com.mind5.payment.customerPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.action.CusparchVisiEnforceUserCustomerKey;
import br.com.mind5.payment.customerPartnerSearch.model.action.CusparchVisiRootSelect;

public final class CusparchRootSelectUserCustomer extends DeciTreeTemplateRead<CusparchInfo> {
	
	public CusparchRootSelectUserCustomer(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparchInfo> buildCheckerHook(DeciTreeOption<CusparchInfo> option) {
		List<ModelChecker<CusparchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparchInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparchInfo> option) {
		List<ActionStd<CusparchInfo>> actions = new ArrayList<>();		
		
		ActionStd <CusparchInfo> enforceKey = new ActionStdCommom <CusparchInfo>(option, CusparchVisiEnforceUserCustomerKey.class);
		ActionLazy<CusparchInfo> select     = new ActionLazyCommom<CusparchInfo>(option, CusparchVisiRootSelect.class);
		
		enforceKey.addPostAction(select);
		
		actions.add(enforceKey);			
		return actions;
	}
}
