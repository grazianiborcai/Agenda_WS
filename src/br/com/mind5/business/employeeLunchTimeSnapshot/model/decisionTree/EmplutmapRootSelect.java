package br.com.mind5.business.employeeLunchTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.action.EmplutmapVisiMergeStolis;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.action.EmplutmapVisiMergeToSelect;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.action.EmplutmapVisiMergeWeekday;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.checker.EmplutmapCheckLangu;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.checker.EmplutmapCheckOwner;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.checker.EmplutmapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmplutmapRootSelect extends DeciTreeTemplateRead<EmplutmapInfo> {
	
	public EmplutmapRootSelect(DeciTreeOption<EmplutmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmapInfo> buildCheckerHook(DeciTreeOption<EmplutmapInfo> option) {
		List<ModelChecker<EmplutmapInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmapCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmapInfo> option) {
		List<ActionStd<EmplutmapInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmapInfo> select = new ActionStdCommom<EmplutmapInfo>(option, EmplutmapVisiMergeToSelect.class);
		ActionLazy<EmplutmapInfo> mergeWeekday = new ActionLazyCommom<EmplutmapInfo>(option, EmplutmapVisiMergeWeekday.class);
		ActionLazy<EmplutmapInfo> mergeStolis = new ActionLazyCommom<EmplutmapInfo>(option, EmplutmapVisiMergeStolis.class);
		
		select.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeStolis);
		
		actions.add(select);
		return actions;
	}
}
