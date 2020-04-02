package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.action.StdPayparSelect;
import br.com.mind5.business.masterData.model.checker.PayparCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPayparSelect extends DeciTreeReadTemplate<PayparInfo> {
	
	public RootPayparSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayparInfo> buildDecisionCheckerHook(DeciTreeOption<PayparInfo> option) {
		List<ModelChecker<PayparInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<PayparInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparInfo> option) {
		List<ActionStdV1<PayparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayparInfo> select = new StdPayparSelect(option);
		
		actions.add(select);
		return actions;
	}
}
