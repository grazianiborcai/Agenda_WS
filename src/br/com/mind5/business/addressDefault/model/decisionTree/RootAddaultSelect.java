package br.com.mind5.business.addressDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.action.StdAddaultMergeToSelect;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckLangu;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootAddaultSelect extends DeciTreeTemplateWrite<AddaultInfo> {
	
	public RootAddaultSelect(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddaultInfo> buildCheckerHook(DeciTreeOption<AddaultInfo> option) {
		List<ModelChecker<AddaultInfo>> queue = new ArrayList<>();		
		ModelChecker<AddaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddaultCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddaultCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddaultInfo>> buildActionsOnPassedHook(DeciTreeOption<AddaultInfo> option) {
		List<ActionStd<AddaultInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddaultInfo> select = new StdAddaultMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
