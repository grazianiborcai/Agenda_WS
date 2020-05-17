package br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.action.StdRefupowarchMergeToSelect;
import br.com.mind5.business.refundPolicyOwnerSearch.model.checker.RefupowarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefupowarchSelect extends DeciTreeTemplateReadV2<RefupowarchInfo> {
	
	public RootRefupowarchSelect(DeciTreeOption<RefupowarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupowarchInfo> buildCheckerHook(DeciTreeOption<RefupowarchInfo> option) {
		List<ModelCheckerV1<RefupowarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupowarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupowarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupowarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupowarchInfo> option) {
		List<ActionStdV1<RefupowarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefupowarchInfo> select = new StdRefupowarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
