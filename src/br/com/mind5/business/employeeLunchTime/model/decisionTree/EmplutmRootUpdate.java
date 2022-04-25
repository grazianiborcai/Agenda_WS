package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoUpdate;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEnforceLChanged;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeUsername;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiNodeSnapshot;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckEmp;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckEmposarch;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckExist;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckLangu;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckOwner;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckRange;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckRangeLen;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckStorauth;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckStore;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckEmpworg;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckWeekday;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmRootUpdate extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmRootUpdate(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckRange(checkerOption);
		queue.add(checker);

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckRangeLen(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckWeekday(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckEmposarch(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckEmpworg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckStorauth(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> enforceLChanged = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiEnforceLChanged.class);
		ActionLazy<EmplutmInfo> enforceLChangedBy = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiMergeUsername.class);
		ActionLazy<EmplutmInfo> update = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiDaoUpdate.class);
		ActionLazy<EmplutmInfo> snapshot = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiNodeSnapshot.class);
		ActionStd<EmplutmInfo> select = new EmplutmRootSelect(option).toAction();
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		snapshot.addPostAction(update);
		
		actions.add(enforceLChanged);
		actions.add(select);
		
		return actions;
	}
}
