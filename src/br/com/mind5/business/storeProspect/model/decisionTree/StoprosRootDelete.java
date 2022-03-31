package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiDaoDelete;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiDaoUpdate;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiEnforceLChanged;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiMergeToSelect;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckDelete;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckExist;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckSysotup;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoprosRootDelete extends DeciTreeTemplateWrite<StoprosInfo> {	
	
	public StoprosRootDelete(DeciTreeOption<StoprosInfo> option) {
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
		
		ActionStd<StoprosInfo> select = new ActionStdCommom<StoprosInfo>(option, StoprosVisiMergeToSelect.class);
		ActionLazy<StoprosInfo> enforceLChanged = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiEnforceLChanged.class);
		ActionLazy<StoprosInfo> update = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiDaoUpdate.class);
		ActionLazy<StoprosInfo> delete = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiDaoDelete.class);			
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(select);		
		return actions;
	}
}
