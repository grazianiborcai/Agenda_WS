package br.com.mind5.business.employeeWorkTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.action.EmpwotmapVisiDaoInsert;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.action.EmpwotmapVisiRootSelect;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckLangu;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckOwner;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpwotmapRootInsert extends DeciTreeTemplateWrite<EmpwotmapInfo> {
	
	public EmpwotmapRootInsert(DeciTreeOption<EmpwotmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmapInfo> buildCheckerHook(DeciTreeOption<EmpwotmapInfo> option) {
		List<ModelChecker<EmpwotmapInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmapInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotmapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotmapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotmapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	
	@Override protected List<ActionStd<EmpwotmapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmapInfo> option) {
		List<ActionStd<EmpwotmapInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmapInfo> insert = new ActionStdCommom<EmpwotmapInfo>(option, EmpwotmapVisiDaoInsert.class);
		ActionLazy<EmpwotmapInfo> select = new ActionLazyCommom<EmpwotmapInfo>(option, EmpwotmapVisiRootSelect.class);
		
		insert.addPostAction(select);
		
		actions.add(insert);				
		return actions;
	}
}
