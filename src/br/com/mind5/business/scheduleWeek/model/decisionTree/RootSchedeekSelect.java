package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckOwner;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckRead;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedeekSelect extends DeciTreeTemplateWrite<SchedeekInfo> {
	
	public RootSchedeekSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekInfo> buildCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelChecker<SchedeekInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStd<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedeekInfo> select = new NodeSchedeekSelect(option).toAction();
		
		actions.add(select);
		return actions;
	}
}
