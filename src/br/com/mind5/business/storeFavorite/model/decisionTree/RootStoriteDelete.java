package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteDaoDelete;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckExist;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStoriteDelete extends DeciTreeTemplateWrite<StoriteInfo> {
	
	public RootStoriteDelete(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelChecker<StoriteInfo>> queue = new ArrayList<>();		
		ModelChecker<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoriteCheckWrite(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoriteCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueue<StoriteInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStd<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStd<StoriteInfo> delete = new StdStoriteDaoDelete(option);		
		actions.add(delete);
		
		return actions;
	}
}
