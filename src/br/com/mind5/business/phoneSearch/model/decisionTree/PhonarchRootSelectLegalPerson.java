package br.com.mind5.business.phoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.action.PhonarchVisiEnforceLegalPersonKey;
import br.com.mind5.business.phoneSearch.model.action.PhonarchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhonarchRootSelectLegalPerson extends DeciTreeTemplateWrite<PhonarchInfo> {
	
	public PhonarchRootSelectLegalPerson(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonarchInfo> buildCheckerHook(DeciTreeOption<PhonarchInfo> option) {
		List<ModelChecker<PhonarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonarchInfo> checker;	

		checker = new ModelCheckerDummy<PhonarchInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonarchInfo> option) {
		List<ActionStd<PhonarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonarchInfo> enforceLegalPersonKey = new ActionStdCommom<PhonarchInfo>(option, PhonarchVisiEnforceLegalPersonKey.class);
		ActionLazy<PhonarchInfo> select = new ActionLazyCommom<PhonarchInfo>(option, PhonarchVisiRootSelect.class);
		
		enforceLegalPersonKey.addPostAction(select);
		
		actions.add(enforceLegalPersonKey);		
		return actions;
	}
}
