package br.com.gda.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.action.LazyFeewnerRootSelect;
import br.com.gda.business.feeOwner.model.action.StdFeewnerEnforceCategServ;
import br.com.gda.business.feeOwner.model.checker.FeewnerCheckReadService;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFeewnerSelectService extends DeciTreeReadTemplate<FeewnerInfo> {
	
	public RootFeewnerSelectService(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeewnerInfo> buildDecisionCheckerHook(DeciTreeOption<FeewnerInfo> option) {		
		List<ModelChecker<FeewnerInfo>> queue = new ArrayList<>();		
		ModelChecker<FeewnerInfo> checker;
		
		checker = new FeewnerCheckReadService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStd<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStd<FeewnerInfo> enforceCateg = new StdFeewnerEnforceCategServ(option);
		ActionLazy<FeewnerInfo> select = new LazyFeewnerRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
