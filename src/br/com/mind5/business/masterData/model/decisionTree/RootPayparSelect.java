package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.action.StdPayparSelect;
import br.com.mind5.business.masterData.model.checker.PayparCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootPayparSelect extends DeciTreeTemplateReadV1<PayparInfo> {
	
	public RootPayparSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayparInfo> buildCheckerHook(DeciTreeOption<PayparInfo> option) {
		List<ModelCheckerV1<PayparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<PayparInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparInfo> option) {
		List<ActionStdV1<PayparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayparInfo> select = new StdPayparSelect(option);
		
		actions.add(select);
		return actions;
	}
}
