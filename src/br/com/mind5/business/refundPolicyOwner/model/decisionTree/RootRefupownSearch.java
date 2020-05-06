package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownMergeRefupo;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownRootSelect;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownEnforceDefault;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownMergeRefupownarch;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckRefupownarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefupownSearch extends DeciTreeTemplateReadV2<RefupownInfo> {
	
	public RootRefupownSearch(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupownInfo> buildCheckerHook(DeciTreeOption<RefupownInfo> option) {
		List<ModelCheckerV1<RefupownInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupownInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupownCheckRefupownarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefupownInfo> mergeRefupownarch = new StdRefupownMergeRefupownarch(option);
		ActionLazyV1<RefupownInfo> select = new LazyRefupownRootSelect(option.conn, option.schemaName);
		
		mergeRefupownarch.addPostAction(select);
		
		actions.add(mergeRefupownarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefupownInfo> mergeRefupownarch = new StdRefupownEnforceDefault(option);
		ActionLazyV1<RefupownInfo> mergeRefupo = new LazyRefupownMergeRefupo(option.conn, option.schemaName);
		
		mergeRefupownarch.addPostAction(mergeRefupo);
		
		actions.add(mergeRefupownarch);
		return actions;
	}
}
