package br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.action.StdRefupowarchMergeToSelect;
import br.com.mind5.business.refundPolicyStoreSearch.model.checker.RefuporarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefuporarchSelect extends DeciTreeTemplateReadV2<RefuporarchInfo> {
	
	public RootRefuporarchSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuporarchInfo> buildCheckerHook(DeciTreeOption<RefuporarchInfo> option) {
		List<ModelCheckerV1<RefuporarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuporarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporarchInfo> option) {
		List<ActionStdV1<RefuporarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefuporarchInfo> select = new StdRefupowarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
