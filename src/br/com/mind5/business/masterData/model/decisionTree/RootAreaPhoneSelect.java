package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.mind5.business.masterData.model.checker.AreaPhoneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootAreaPhoneSelect extends DeciTreeReadTemplate<AreaPhoneInfo> {
	
	public RootAreaPhoneSelect(DeciTreeOption<AreaPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AreaPhoneInfo> buildDecisionCheckerHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ModelChecker<AreaPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<AreaPhoneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreaPhoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<AreaPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<AreaPhoneInfo> option) {
		List<ActionStd<AreaPhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<AreaPhoneInfo> select = new StdAreaPhoneSelect(option);
		
		actions.add(select);
		return actions;
	}
}
