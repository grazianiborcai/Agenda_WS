package br.com.mind5.business.employeeLunchTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.business.employeeLunchTimeConflict.model.action.EmpulranVisiMergeToSelect;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulranCheckEmp;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulranCheckLangu;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulranCheckOwner;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulranCheckRead;
import br.com.mind5.business.employeeLunchTimeConflict.model.checker.EmpulranCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpulranRootSelect extends DeciTreeTemplateRead<EmpulranInfo> {
	
	public EmpulranRootSelect(DeciTreeOption<EmpulranInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpulranInfo> buildCheckerHook(DeciTreeOption<EmpulranInfo> option) {
		List<ModelChecker<EmpulranInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpulranInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpulranCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulranCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulranCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulranCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpulranCheckEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpulranInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpulranInfo> option) {
		List<ActionStd<EmpulranInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpulranInfo> select = new ActionStdCommom<EmpulranInfo>(option, EmpulranVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
