package br.com.mind5.business.employeeLunchTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.action.EmplutmarchVisiMergeToSelect;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckLangu;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckOwner;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmplutmarchRootSelect extends DeciTreeTemplateRead<EmplutmarchInfo> {
	
	public EmplutmarchRootSelect(DeciTreeOption<EmplutmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmarchInfo> buildCheckerHook(DeciTreeOption<EmplutmarchInfo> option) {
		List<ModelChecker<EmplutmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmarchInfo> option) {
		List<ActionStd<EmplutmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmarchInfo> select = new ActionStdCommom<EmplutmarchInfo>(option, EmplutmarchVisiMergeToSelect.class);

		actions.add(select);
		return actions;
	}
}
