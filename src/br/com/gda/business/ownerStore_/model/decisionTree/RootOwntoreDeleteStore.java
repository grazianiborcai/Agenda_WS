package br.com.gda.business.ownerStore_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.business.ownerStore_.model.action.LazyOwntoreDeleteStore;
import br.com.gda.business.ownerStore_.model.action.StdOwntoreMergeToDelete;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckDelete;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckLangu;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckStore;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;


public final class RootOwntoreDeleteStore extends DeciTreeWriteTemplate<OwntoreInfo> {
	
	public RootOwntoreDeleteStore(DeciTreeOption<OwntoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwntoreInfo> buildDecisionCheckerHook(DeciTreeOption<OwntoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OwntoreInfo>> queue = new ArrayList<>();		
		ModelChecker<OwntoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwntoreCheckDelete();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwntoreCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwntoreCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwntoreInfo>> buildActionsOnPassedHook(DeciTreeOption<OwntoreInfo> option) {
		List<ActionStd<OwntoreInfo>> actions = new ArrayList<>();

		ActionStd<OwntoreInfo> mergeToDelete = new StdOwntoreMergeToDelete(option);
		ActionLazy<OwntoreInfo> deleteStore = new LazyOwntoreDeleteStore(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(deleteStore);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
