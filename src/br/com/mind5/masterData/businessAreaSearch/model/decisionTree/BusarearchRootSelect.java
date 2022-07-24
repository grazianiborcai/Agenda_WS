package br.com.mind5.masterData.businessAreaSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.masterData.businessAreaSearch.model.action.BusarearchVisiDaoSelect;
import br.com.mind5.masterData.businessAreaSearch.model.checker.BusarearchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BusarearchRootSelect extends DeciTreeTemplateRead<BusarearchInfo> {
	
	public BusarearchRootSelect(DeciTreeOption<BusarearchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BusarearchInfo> buildCheckerHook(DeciTreeOption<BusarearchInfo> option) {
		List<ModelChecker<BusarearchInfo>> queue = new ArrayList<>();		
		ModelChecker<BusarearchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BusarearchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BusarearchInfo>> buildActionsOnPassedHook(DeciTreeOption<BusarearchInfo> option) {
		List<ActionStd<BusarearchInfo>> actions = new ArrayList<>();
		
		ActionStd<BusarearchInfo> select = new ActionStdCommom<BusarearchInfo>(option, BusarearchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
