package br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.action.StdRefupownarchDaoSelect;
import br.com.mind5.business.refundPolicyOwnerSearch.model.checker.RefupownarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefupownarchSelect extends DeciTreeTemplateReadV2<RefupownarchInfo> {
	
	public RootRefupownarchSelect(DeciTreeOption<RefupownarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupownarchInfo> buildCheckerHook(DeciTreeOption<RefupownarchInfo> option) {
		List<ModelCheckerV1<RefupownarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupownarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupownarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownarchInfo> option) {
		List<ActionStdV1<RefupownarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefupownarchInfo> select = new StdRefupownarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
