package br.com.mind5.masterData.businessArea.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.action.StdBusareaDaoSelect;
import br.com.mind5.masterData.businessArea.model.checker.BusareaCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootBusareaSelect extends DeciTreeTemplateReadV2<BusareaInfo> {
	
	public RootBusareaSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<BusareaInfo> buildCheckerHook(DeciTreeOption<BusareaInfo> option) {
		List<ModelCheckerV1<BusareaInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<BusareaInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusareaCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<BusareaInfo>> buildActionsOnPassedHook(DeciTreeOption<BusareaInfo> option) {
		List<ActionStdV1<BusareaInfo>> actions = new ArrayList<>();
		
		ActionStdV1<BusareaInfo> select = new StdBusareaDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
