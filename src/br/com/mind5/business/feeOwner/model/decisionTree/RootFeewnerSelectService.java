package br.com.mind5.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.LazyFeewnerRootSelect;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerEnforceCategServ;
import br.com.mind5.business.feeOwner.model.checker.FeewnerCheckReadService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFeewnerSelectService extends DeciTreeReadTemplate<FeewnerInfo> {
	
	public RootFeewnerSelectService(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeewnerInfo> buildDecisionCheckerHook(DeciTreeOption<FeewnerInfo> option) {		
		List<ModelChecker<FeewnerInfo>> queue = new ArrayList<>();		
		ModelChecker<FeewnerInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeewnerCheckReadService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStdV1<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeewnerInfo> enforceCateg = new StdFeewnerEnforceCategServ(option);
		ActionLazyV1<FeewnerInfo> select = new LazyFeewnerRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
