package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiMergeTimezone;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiMergeToSelect;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckEmp;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckOwner;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckRead;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class EmplateRootSelect extends DeciTreeTemplateRead<EmplateInfo> {
	
	public EmplateRootSelect(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplateCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckStore(checkerOption);
		queue.add(checker);	
		/*
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckStorauth(checkerOption);	//TODO: corrigir Storauth - Username ao inves do User
		queue.add(checker);	
		*/
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> select = new ActionStdCommom<EmplateInfo>(option, EmplateVisiMergeToSelect.class);
		ActionLazy<EmplateInfo> mergeTimezone = new ActionLazyCommom<EmplateInfo>(option, EmplateVisiMergeTimezone.class);
		
		select.addPostAction(mergeTimezone);
		
		actions.add(select);
		return actions;
	}
}
