package br.com.mind5.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.action.LazyFeewnerRootSelect;
import br.com.mind5.business.feeOwner.model.action.StdFeewnerEnforceCategServ;
import br.com.mind5.business.feeOwner.model.checker.FeewnerCheckReadService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootFeewnerSelectService extends DeciTreeTemplateReadV1<FeewnerInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV1<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStdV1<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FeewnerInfo> enforceCateg = new StdFeewnerEnforceCategServ(option);
		ActionLazyV1<FeewnerInfo> select = new LazyFeewnerRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(select);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
