package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiRootInsert;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiEnforceEmposKey;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiMergeStowotm;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckEmpwotarch;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStowotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpwotmNodeInsertFromStore extends DeciTreeTemplateWrite<EmpwotmInfo> {
	
	public EmpwotmNodeInsertFromStore(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotmCheckStowotarch(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmpwotmCheckEmpwotarch(checkerOption);
		queue.add(checker);			
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceEmposKey = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiEnforceEmposKey.class);
		ActionLazy<EmpwotmInfo> mergeStowotm = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiMergeStowotm.class);
		ActionLazy<EmpwotmInfo> insert = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiRootInsert.class);
		
		enforceEmposKey.addPostAction(mergeStowotm);
		mergeStowotm.addPostAction(insert);
		
		actions.add(enforceEmposKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> success = new ActionStdSuccessCommom<EmpwotmInfo>(option);
		
		actions.add(success);
		return actions;
	}	
}
