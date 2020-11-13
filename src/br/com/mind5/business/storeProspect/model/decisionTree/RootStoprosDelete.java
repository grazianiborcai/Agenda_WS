package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosCheckSysotup;
import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosDaoDelete;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosDaoUpdate;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceLChanged;
import br.com.mind5.business.storeProspect.model.action.StdStoprosMergeToSelect;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckDelete;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckExist;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStoprosDelete extends DeciTreeTemplateWrite<StoprosInfo> {	
	
	public RootStoprosDelete(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelChecker<StoprosInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprosInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoprosCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckSysotup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueue<StoprosInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStd<StoprosInfo>> actions = new ArrayList<>();
		
		ActionStd<StoprosInfo> select = new StdStoprosMergeToSelect(option);
		ActionLazy<StoprosInfo> enforceLChanged = new LazyStoprosEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> update = new LazyStoprosDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StoprosInfo> delete = new LazyStoprosDaoDelete(option.conn, option.schemaName);			
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(select);		
		return actions;
	}
}
