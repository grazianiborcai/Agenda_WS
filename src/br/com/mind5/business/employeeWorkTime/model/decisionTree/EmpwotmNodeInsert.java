package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiDaoInsert;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiDaoUpdate;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiNodeSnapshot;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpwotmNodeInsert extends DeciTreeTemplateWrite<EmpwotmInfo> {
	
	public EmpwotmNodeInsert(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;
		checker = new EmpwotmCheckSoftDelete(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> insert = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiDaoInsert.class);
		ActionLazy<EmpwotmInfo> snapshot = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiNodeSnapshot.class);
		
		insert.addPostAction(snapshot);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> update = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiDaoUpdate.class);
		ActionLazy<EmpwotmInfo> snapshot = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiNodeSnapshot.class);
		
		update.addPostAction(snapshot);
		
		actions.add(update);
		return actions;
	}
}
