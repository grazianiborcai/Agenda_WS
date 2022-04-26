package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeEmplutmarchEmpos;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiRootDelete;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckEmplutmarchEmpos;
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

public final class EmplutmNodeDeleteFromEmpos extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmNodeDeleteFromEmpos(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckEmplutmarchEmpos(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerHelperQueue<EmplutmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> mergeEmplutmarch = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiMergeEmplutmarchEmpos.class);
		ActionLazy<EmplutmInfo> delete = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiRootDelete.class);
		
		mergeEmplutmarch.addPostAction(delete);
		
		actions.add(mergeEmplutmarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> success = new ActionStdSuccessCommom<EmplutmInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
