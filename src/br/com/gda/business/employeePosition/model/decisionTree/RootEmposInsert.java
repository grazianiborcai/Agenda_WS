package br.com.gda.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.action.LazyEmposMergeUsername;
import br.com.gda.business.employeePosition.model.action.LazyEmposNodeInsert;
import br.com.gda.business.employeePosition.model.action.LazyEmposRootSelect;
import br.com.gda.business.employeePosition.model.action.StdEmposEnforceLChanged;
import br.com.gda.business.employeePosition.model.checker.EmposCheckEmp;
import br.com.gda.business.employeePosition.model.checker.EmposCheckPosition;
import br.com.gda.business.employeePosition.model.checker.EmposCheckStorauth;
import br.com.gda.business.employeePosition.model.checker.EmposCheckExist;
import br.com.gda.business.employeePosition.model.checker.EmposCheckLangu;
import br.com.gda.business.employeePosition.model.checker.EmposCheckOwner;
import br.com.gda.business.employeePosition.model.checker.EmposCheckStore;
import br.com.gda.business.employeePosition.model.checker.EmposCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmposInsert extends DeciTreeWriteTemplate<EmposInfo> {
	
	public RootEmposInsert(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildDecisionCheckerHook(DeciTreeOption<EmposInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmposCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmposCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckPosition(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckStorauth(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new StdEmposEnforceLChanged(option);
		ActionLazy<EmposInfo> enforceLChangedBy = new LazyEmposMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmposInfo> nodeInsert = new LazyEmposNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmposInfo> select = new LazyEmposRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		//actions.add(new NodeEmposInsertEWT(option).toAction());

		
		actions.add(enforceLChanged);
		return actions;
		
		//TODO: O InsertEWT pode gerar conflitos. Imagine que um empregado j� esteja lotado em uma outra loja.
	}
}
