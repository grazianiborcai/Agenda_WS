package br.com.mind5.masterData.businessArea.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.action.BusareaVisiDaoSelect;
import br.com.mind5.masterData.businessArea.model.checker.BusareaCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BusareaRootSelect extends DeciTreeTemplateRead<BusareaInfo> {
	
	public BusareaRootSelect(DeciTreeOption<BusareaInfo> option) {
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
		
		ActionStd<BusareaInfo> select = new ActionStdCommom<BusareaInfo>(option, BusareaVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
