package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.business.masterData.model.action.StdBusinessSelect;
import br.com.mind5.business.masterData.model.checker.BusinessCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootBusinessSelect extends DeciTreeReadTemplate<BusinessInfo> {
	
	public RootBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BusinessInfo> buildDecisionCheckerHook(DeciTreeOption<BusinessInfo> option) {
		List<ModelChecker<BusinessInfo>> queue = new ArrayList<>();		
		ModelChecker<BusinessInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusinessCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BusinessInfo>> buildActionsOnPassedHook(DeciTreeOption<BusinessInfo> option) {
		List<ActionStd<BusinessInfo>> actions = new ArrayList<>();
		
		ActionStd<BusinessInfo> select = new StdBusinessSelect(option);
		
		actions.add(select);
		return actions;
	}
}
