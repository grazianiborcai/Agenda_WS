package br.com.mind5.business.employeeMaterialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.action.EmpmarchVisiMergeToSelect;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckLangu;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckOwner;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpmarchRootSelect extends DeciTreeTemplateRead<EmpmarchInfo> {
	
	public EmpmarchRootSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmarchInfo> buildCheckerHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ModelChecker<EmpmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ActionStd<EmpmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmarchInfo> select = new ActionStdCommom<EmpmarchInfo>(option, EmpmarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
