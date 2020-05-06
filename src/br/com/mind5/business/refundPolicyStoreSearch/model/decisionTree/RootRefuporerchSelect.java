package br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.action.StdRefuporerchDaoSelect;
import br.com.mind5.business.refundPolicyStoreSearch.model.checker.RefuporerchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefuporerchSelect extends DeciTreeTemplateReadV2<RefuporerchInfo> {
	
	public RootRefuporerchSelect(DeciTreeOption<RefuporerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuporerchInfo> buildCheckerHook(DeciTreeOption<RefuporerchInfo> option) {
		List<ModelCheckerV1<RefuporerchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuporerchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporerchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporerchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporerchInfo> option) {
		List<ActionStdV1<RefuporerchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefuporerchInfo> select = new StdRefuporerchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
