package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.action.StdRefugradarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.checker.RefugradarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugradarchSelect extends DeciTreeTemplateReadV2<RefugradarchInfo> {
	
	public RootRefugradarchSelect(DeciTreeOption<RefugradarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugradarchInfo> buildCheckerHook(DeciTreeOption<RefugradarchInfo> option) {
		List<ModelCheckerV1<RefugradarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugradarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugradarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugradarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugradarchInfo> option) {
		List<ActionStdV1<RefugradarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugradarchInfo> select = new StdRefugradarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
