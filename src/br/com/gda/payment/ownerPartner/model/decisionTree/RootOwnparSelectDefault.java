package br.com.gda.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.action.LazyOwnparRootSelect;
import br.com.gda.payment.ownerPartner.model.action.StdOwnparEnforceDefault;
import br.com.gda.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class RootOwnparSelectDefault extends DeciTreeReadTemplate<OwnparInfo> {
	
	public RootOwnparSelectDefault(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnparInfo> buildDecisionCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		
		checker = new OwnparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStd<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnparInfo> enforceDefault = new StdOwnparEnforceDefault(option);
		ActionLazy<OwnparInfo> rootSelect = new LazyOwnparRootSelect(option.conn, option.schemaName);
		
		enforceDefault.addPostAction(rootSelect);
		
		actions.add(enforceDefault);
		return actions;
	}
}
