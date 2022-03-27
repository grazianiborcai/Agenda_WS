package br.com.mind5.business.employeeWorkTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.action.EmpwotmapVisiMergeStolis;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.action.EmpwotmapVisiMergeToSelect;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.action.EmpwotmapVisiMergeWeekday;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckLangu;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckOwner;
import br.com.mind5.business.employeeWorkTimeSnapshot.model.checker.EmpwotmapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpwotmapRootSelect extends DeciTreeTemplateRead<EmpwotmapInfo> {
	
	public EmpwotmapRootSelect(DeciTreeOption<EmpwotmapInfo> option) {
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
		checker = new EmpwotmapCheckRead(checkerOption);
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
		
		ActionStd<EmpwotmapInfo> select = new ActionStdCommom<EmpwotmapInfo>(option, EmpwotmapVisiMergeToSelect.class);
		ActionLazy<EmpwotmapInfo> mergeWeekday = new ActionLazyCommom<EmpwotmapInfo>(option, EmpwotmapVisiMergeWeekday.class);
		ActionLazy<EmpwotmapInfo> mergeStolis = new ActionLazyCommom<EmpwotmapInfo>(option, EmpwotmapVisiMergeStolis.class);
		
		select.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeStolis);
		
		actions.add(select);
		return actions;
	}
}
