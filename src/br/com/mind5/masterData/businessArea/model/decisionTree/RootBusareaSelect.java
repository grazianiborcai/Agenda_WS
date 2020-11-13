package br.com.mind5.masterData.businessArea.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.action.StdBusareaDaoSelect;
import br.com.mind5.masterData.businessArea.model.checker.BusareaCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootBusareaSelect extends DeciTreeTemplateRead<BusareaInfo> {
	
	public RootBusareaSelect(DeciTreeOption<BusareaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BusareaInfo> buildCheckerHook(DeciTreeOption<BusareaInfo> option) {
		List<ModelChecker<BusareaInfo>> queue = new ArrayList<>();		
		ModelChecker<BusareaInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusareaCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BusareaInfo>> buildActionsOnPassedHook(DeciTreeOption<BusareaInfo> option) {
		List<ActionStd<BusareaInfo>> actions = new ArrayList<>();
		
		ActionStd<BusareaInfo> select = new StdBusareaDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
