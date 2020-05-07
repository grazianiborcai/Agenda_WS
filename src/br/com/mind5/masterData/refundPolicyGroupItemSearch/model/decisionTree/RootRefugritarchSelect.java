package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action.StdRefugritarchDaoSelect;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker.RefugritarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugritarchSelect extends DeciTreeTemplateReadV2<RefugritarchInfo> {
	
	public RootRefugritarchSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugritarchInfo> buildCheckerHook(DeciTreeOption<RefugritarchInfo> option) {
		List<ModelCheckerV1<RefugritarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugritarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugritarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugritarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritarchInfo> option) {
		List<ActionStdV1<RefugritarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugritarchInfo> select = new StdRefugritarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
