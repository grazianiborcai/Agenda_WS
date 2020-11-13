package br.com.mind5.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.LazyFeewnerRootSelect;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerEnforceCategServ;
import br.com.mind5.business.feeOwner.model.checker.FeewnerCheckReadService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFeewnerSelectService extends DeciTreeTemplateReadV2<FeewnerInfo> {
	
	public RootFeewnerSelectService(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeewnerInfo> buildCheckerHook(DeciTreeOption<FeewnerInfo> option) {		
		List<ModelCheckerV1<FeewnerInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeewnerInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeewnerCheckReadService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStdV2<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FeewnerInfo> enforceCateg = new StdFeewnerEnforceCategServ(option);
		ActionLazy<FeewnerInfo> select = new LazyFeewnerRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
