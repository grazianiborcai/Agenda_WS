package br.com.mind5.business.storeTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.model.action.LazyStorextsnapDaoInsert;
import br.com.mind5.business.storeTextSnapshot.model.action.StdStorextsnapMergeStorext;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckStorext;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckOwner;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStorextsnapInsert extends DeciTreeTemplateWrite<StorextsnapInfo> {
	
	public RootStorextsnapInsert(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextsnapInfo> buildCheckerHook(DeciTreeOption<StorextsnapInfo> option) {		
		List<ModelChecker<StorextsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckStorext(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextsnapInfo> option) {
		List<ActionStd<StorextsnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorextsnapInfo> mergeStorext = new StdStorextsnapMergeStorext(option);	
		ActionLazy<StorextsnapInfo> insert = new LazyStorextsnapDaoInsert(option.conn, option.schemaName);	
		
		mergeStorext.addPostAction(insert);
		
		actions.add(mergeStorext);
		return actions;
	}
}
